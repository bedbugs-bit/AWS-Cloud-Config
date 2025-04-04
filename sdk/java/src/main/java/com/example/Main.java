package com.example;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class Main {
    public static void main(String[] args) {
        // Create S3 client
        S3Client s3 = S3Client.builder()
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .region(Region.of(System.getenv("AWS_REGION")))
                .build();

        // List buckets
        ListBucketsResponse response = s3.listBuckets(ListBucketsRequest.builder().build());
        
        System.out.println("S3 Buckets:");
        response.buckets().forEach(bucket -> 
            System.out.println("- " + bucket.name())
        );
    }
}