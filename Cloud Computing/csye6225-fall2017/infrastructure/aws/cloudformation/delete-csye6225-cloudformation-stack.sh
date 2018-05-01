#!/usr/bin/env bash

#Ask for stack name
echo "Enter the stack name"

read stackName

#Update the stack EC2 instance
instance_id=$(aws ec2 describe-instances --query "Reservations[*].Instances[*].InstanceId[]" --filters "Name=tag-key,Values=aws:cloudformation:stack-name" "Name=tag-value,Values=$stackName" --output=text)

aws ec2 modify-instance-attribute --instance-id $instance_id --no-disable-api-termination

sleep 10

#Delete the stack
aws cloudformation delete-stack --stack-name $stackName

echo "Stack Deletion in progress..."

aws cloudformation wait stack-delete-complete --stack-name $stackName

#Check the status
echo "Stack deleted successfully"
