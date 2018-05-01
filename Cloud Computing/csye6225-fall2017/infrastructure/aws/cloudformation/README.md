# csye6225-fall2017

We created two bash script 1. create-csye6225-cloudformation-stack.sh -to create an cloud formation stack 2. elete-csye6225-cloudformation-stack.sh-to terminte the stack
It also has a json templte which helps to provide specific details for the instances, security groups, subnet groups, DynamoDB table and Record set.
```
1. create-csye6225-cloudformation-stack.sh :
-->     a.Security Group
        b.EC2 Instance with the specifications below
        c.Resource Record in the Route 53 zone for your domain with the IP of the newly launched EC2 instance
        d.Create DBSecurity Group with ingress rule to allow TCP traffic on port 3306 only
        e.Create a DynamoDB table with specific details
        f.Create S3 Bucket with name "domain_name.csye6225.com"
        g.Create RDS Instance with the specifications below
2. terminate-csye6225-cloudformation-stack.sh:
-->     User will be requested to enter stack name. Once user enters stack name, that stackname will be terminated (after deleting Security Groups, RDS and EC2 instances, Record set, subnet group and DB Table)

```

### EC2 Instance Specifications

```
Amazon Machine Image (AMI)	                Ubuntu Server 16.04 LTS (HVM), SSD Volume Type - ami-cd0f5cb6
Instance Type	                            t2.micro
Protect against accidental termination	    Yes
Root Volume Size	                        16
Root Volume Type	                        General Purpose SSD (GP2)
Security Group	                            csye6225-fall2017-STACK_NAME-webapp

```
### RDS Instance Specifications
```
Database Engine 	MySQL
Database Engine 	MySQL 5.6.35
DB Instance Class 	db.t2.medium
Multi-AZ deployment 	No
DB instance identifier 	csye6225-fall2017
Master username 	csye6225master
Master password 	csye6225password
Subnet group 	Newly created subnet for RDS instances
Public accessibility 	No
Database name 	csye6225

```


# Execution 

### Running your application

## Running from an CLI.
```
bash create-csye6225-cloudformation-stack.sh 
bash terminate-csye6225-cloudformation-stack.sh

```



## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors
```
Rishabh Jain
```



