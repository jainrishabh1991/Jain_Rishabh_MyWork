package com.csye6225.demo.config;

//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
////import com.amazonaws.services.s3.AmazonS3Client;
//import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
//import org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
//import org.springframework.cloud.aws.jdbc.datasource.TomcatJdbcDataSourceFactory;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.cloud.aws.jdbc.datasource.DataSourceFactory;

@Configuration
public class AWSConfiguration {

    @Value("${cloud.aws.region}")
    private String region;

    @Bean
    public AmazonS3 amazonS3Client() {
        AmazonS3 amazonS3Client= AmazonS3ClientBuilder.standard().withCredentials(new InstanceProfileCredentialsProvider(false)).build();
        return amazonS3Client;
    }


}
