#!/usr/bin/env bash

sudo rm -rf /var/lib/tomcat8/webapps/ROOT
sudo systemctl restart tomcat8
sudo cp /home/ubuntu/awslogs.conf /var/awslogs/etc
sudo systemctl restart awslogs.service
