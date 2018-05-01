#!/usr/bin/env bash

#Ask for stack name
echo "Enter the stack name"

read stackName


#Launch ec2

#2) Get VPC Id and Subnet ID
# Get VPC ID
export VPC_ID=$(aws ec2 describe-vpcs --query "Vpcs[0].VpcId" --output text)

echo $VPC_ID

# Use the VPC ID to get subnet id
export SUBNET_ID=$(aws ec2 describe-subnets --filters "Name=vpc-id, Values=$VPC_ID" --query "Subnets[0].SubnetId" --output text)

echo $SUBNET_ID

#Adding "A" Resource Record Set
string=$(aws route53 list-hosted-zones-by-name --query 'HostedZones[].Id[]' --output text)

zoneID=${string:12}

echo $zoneID
certi=$(aws acm list-certificates --query 'CertificateSummaryList[].CertificateArn' --output text)
domain_name=$(aws route53 list-hosted-zones-by-name --query 'HostedZones[].Name[]' --output text)
doname=$domain_name
domain_name="ec2."$domain_name
database_user_name="datauser"

keyPair="id_rsa"
rdsUserName="csye6225master"
rdsPassword="csye6225password"

echo $domain_name

echo "csye6225-fall2017-$stackName-webapp"

sleep 5

stack_name="csye6225-fall2017-$stackName-webapp"
echo $stack_name
sdomain="${doname}csye6225.com"

#2) Create instance using cloud formation
aws cloudformation create-stack --stack-name $stackName --template-body file:///tmp/cloudformation_template_complete.json --capabilities "CAPABILITY_NAMED_IAM" --parameters ParameterKey=vpcid,ParameterValue=$VPC_ID ParameterKey=subnetid,ParameterValue=$SUBNET_ID ParameterKey=zoneid,ParameterValue=$zoneID ParameterKey=domainname,ParameterValue=$domain_name ParameterKey=stacknameSecurity,ParameterValue=$stack_name ParameterKey=sdomain,ParameterValue=$sdomain ParameterKey=dbuser,ParameterValue=$database_user_name ParameterKey=keyPair,ParameterValue=$keyPair ParameterKey=rdsUserName,ParameterValue=$rdsUserName ParameterKey=rdsPassword,ParameterValue=$rdsPassword ParameterKey=originalDomain,ParameterValue=$doname ParameterKey=certi,ParameterValue=$certi

#Check the status

echo "Stack Creation in progress..."

aws cloudformation wait stack-create-complete --stack-name $stackName

stackStatus=$(aws cloudformation describe-stacks --stack-name $stackName --query 'Stacks[].StackStatus[]' --output text)


if [[ $stackStatus == "CREATE_COMPLETE" ]]
then
echo "Stack created successfully"
else
echo "Error while creating stack"
fi
