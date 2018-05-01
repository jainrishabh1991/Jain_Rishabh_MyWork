# csye6225-fall2017

We created two bash script 1. launch-ec2-instance.sh -to launch an EC2 instance 2. terminate-ec2-instance.sh-to terminte the EC2 instance
```
1. launch-ec2-instance.sh :
--> a.Create security group
    b.Configure security group
    c.Launch EC2 Instance
    d.Wait for instance to be in running state.
    e.Retrieving instance’s public IP address.
    f.Add/Update type A resource record set ec2.YOUR_DOMAIN_NAME.me in the Route 53 zone for your domain with the IP of the newly launched EC2 instance. TTL for the resource record set should be set to 60 seconds.
2. terminate-ec2-instance.sh:
--> User will be asked to enter instance id and that particular instance will be terminated. We will also delete the key pair and the security group.
```

### EC2 Instance Specifications

```
Parameter	                              Value
Amazon Machine Image (AMI)	              Ubuntu Server 16.04 LTS (HVM), SSD Volume Type - ami-cd0f5cb6
Instance Type	                          t2.micro
Protect against accidental termination	  Yes
Root Volume Size	                      16
Root Volume Type	                      General Purpose SSD (GP2)
Security Group	                        csye6225-fall2017-webapp
```

# Execution 

### Running your application

## Running from an CLI.
```
bash launch-ec2-instance.sh
bash terminate-ec2-instance.sh

```







## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors
```
Rishabh Jain
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


