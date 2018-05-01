echo "Enter the instance id you wannt to delete?"
read instance_id
aws ec2 modify-instance-attribute --instance-id $instance_id --no-disable-api-termination
echo "Disable Termination security has been deactivated"
aws ec2 terminate-instances --instance-ids $instance_id

#Delete security groups

ins_status=$(aws ec2 describe-instance-status --instance-id $instance_id --query 'InstanceStatuses[].InstanceState[].Name[]' --output text)
echo $ins_status

echo "Please wait for few minutes. Terminating Instance.."
aws ec2 wait instance-terminated --instance-ids $instance_id
echo "Instance has been terminated"

aws ec2 delete-security-group --group-name csye6225-fall2017-webapp
#Delete keypair
aws ec2 delete-key-pair --key-name MyKeyPair
echo "The security group and key pair has been deleted"

