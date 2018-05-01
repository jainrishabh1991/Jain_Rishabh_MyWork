# csye6225-fall2017

### Process we followed to get SSL certificate and the steps taken to configure it for the 

# Purchase Your SSL Certificate 
```
We used Namecheap to purchase our SSL certificate because it is simple and inexpensive.

Purchasing a certificate is a little confusing because once you pay for it, nothing happens until you activate it.
```
# Activate Your SSL Certificate
```
After you purchase the SSL certificate, you need to activate it in order to receive the certificate files.

In order to activate it, you need to generate a Certificate Signing Request (CSR).  This can be done from any Linux or OSX command line using the command below.

openssl req -new -newkey rsa:2048 -nodes -keyout server.key -out server.csr

You will then be prompted for a number of questions, as shown below. You can just hit Enter on most of the fields to use the default value. The important field is the “Common Name” field. This must be the hostname of your server. If you purchased a wildcard certificate, it must begin with an asterisk (‘*’); for example *.thorntech.com. Otherwise, use your full hostname, like www.thorntech.com. Do not specify a challenge password in the CSR.

[ec2-user@ ssl_setup]$ openssl req -new -newkey rsa:2048 -nodes -keyout server.key -out server.csr
Generating a 2048 bit RSA private key
..........................................................+++
...........................+++
writing new private key to 'server.key'
-----
You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) [XX]:US
State or Province Name (full name) []:Maryland
Locality Name (eg, city) [Default City]:
Organization Name (eg, company) [Default Company Ltd]:ThornTech
Organizational Unit Name (eg, section) []:Dev
Common Name (eg, your name or your server's hostname) []:*.thorntech.com
Email Address []:info@thorntech.com

Please enter the following 'extra' attributes
to be sent with your certificate request
A challenge password []:
An optional company name []:

[ec2-user@ ssl_setup]$ ll
total 8
-rw-rw-r-- 1 ec2-user ec2-user 1066 Aug 18 15:21 server.csr
-rw-rw-r-- 1 ec2-user ec2-user 1704 Aug 18 15:21 server.key

Once you have the CSR generated, you need to provide it to the domain registrar from whom you purchased the SSL certificate.

In the case of Namecheap, you can paste it into the form they provide on the Manage SSL Certificates page.

Once you upload the CSR, they need to verify that you own the domain that was provided in the CSR “Common Name” field. They will send an activation link to one of several email addresses associated with the domain, such as admin@mydomain.com.

You can also choose the email address listed on the WHOIS record for the domain name. It is critical that you have access to the email account you choose or you will not be able to validate the domain. Once you select the email address to use, the certificate authority will send a validation code and a link to the email address you selected. Click on the link and provide the verification code they gave you.

```


# Receive and Save Your SSL Certificate
```
Once you provide the correct verification code, they will email the final certificate to you. The file will come as ZIP file attachment. The zip file will include 4 files:

    Root CA Certificate – AddTrustExternalCARoot.crt
    Intermediate CA Certificate – COMODORSAAddTrustCA.crt
    Intermediate CA Certificate – COMODORSADomainValidationSecureServerCA.crt
    Your PositiveSSL Wildcard Certificate – STAR_thorntech_com.crt

Save this zip file in a safe place. You will need all of these files when you set up your instance on AWS.
```



## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Author
```
Rishabh Jain
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

