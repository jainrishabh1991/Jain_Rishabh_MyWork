#!/usr/bin/env bash
#create security group
aws ec2 create-security-group --group-name csye6225-fall2017-webapp --description "test"

#configure security group
#1)SSH
aws ec2 authorize-security-group-ingress --group-name csye6225-fall2017-webapp --protocol tcp --port 22 --cidr 0.0.0.0/0
echo "Security group has been authorized to allow SSH traffic on TCP protocols"
#2)HTTP
aws ec2 authorize-security-group-ingress --group-name csye6225-fall2017-webapp --protocol tcp --port 80 --cidr 0.0.0.0/0
echo "Security group has been authorized to allow HTTP traffic on TCP protocols"
#3)HTTPS
aws ec2 authorize-security-group-ingress --group-name csye6225-fall2017-webapp --protocol tcp --port 443 --cidr 0.0.0.0/0
echo "Security group has been authorized to allow HTTPS traffic on TCP protocols"

#Launch ec2
#1) Create key-pair
keypair=$(aws ec2 create-key-pair --key-name MyKeyPair)
echo "Keypair has been created"
#2) Run instance
aws ec2 run-instances --image-id ami-cd0f5cb6 --instance-type t2.micro  --key-name MyKeyPair --security-groups csye6225-fall2017-webapp --block-device-mapping 'DeviceName=/dev/sda1,Ebs={VolumeSize=16,VolumeType=gp2}' --disable-api-termination

#Wait till Running State
#1) Get Instance ID
instance_id=$(aws ec2 describe-instances --filter Name="instance-state-name",Values="pending" --query 'Reservations[].Instances[].[InstanceId]' --output text | tail -1)
#2) Check if that status is Running
ins_status=$(aws ec2 describe-instance-status --instance-id $instance_id --query 'InstanceStatuses[].InstanceState[].Name[]' --output text)

echo "Waiting for the instance to get running.."

aws ec2 wait instance-running --instance-ids $instance_id

if [[ $ins_status=="running" ]]
then
echo "The instance is up and Running"
#Retrieving instance Public IP address
public_ip=$(aws ec2 describe-instances --instance-ids $instance_id --query 'Reservations[].Instances[].PublicIpAddress' --output text)
echo "The public ip address is:" $public_ip
else
echo "The instance did not launch correctly.!!"
fi

#Adding "A" Resource Record Set
string=$(aws route53 list-hosted-zones-by-name --query 'HostedZones[].Id[]' --output text)

zoneID=${string:12}

domain_name=$(aws route53 list-hosted-zones-by-name --query 'HostedZones[].Name[]' --output text)

echo "{\"Comment\": \"Adding a new MX record for the zone.\", \"Changes\":[{\"Action\": \"UPSERT\", \"ResourceRecordSet\": { \"Name\": \""$domain_name"\", \"Type\": \"A\", \"TTL\": 60, \"ResourceRecords\": [{\"Value\": \""$public_ip"\"}]}}]}" > /tmp/route53.json

aws route53 change-resource-record-sets --hosted-zone-id $zoneID --change-batch file:///tmp/route53.json
echo "Added A resource record set in Route 53"
