package main

import (
    "context"
    "fmt"
    "log"

    "github.com/aws/aws-sdk-go-v2/config"
    "github.com/aws/aws-sdk-go-v2/service/s3"
)

func main() {
    // Load AWS config from environment variables
    cfg, err := config.LoadDefaultConfig(context.TODO())
    if err != nil {
        log.Fatal(err)
    }

    // Create S3 client
    client := s3.NewFromConfig(cfg)

    // List buckets
    result, err := client.ListBuckets(context.TODO(), &s3.ListBucketsInput{})
    if err != nil {
        log.Fatal(err)
    }

    fmt.Println("S3 Buckets:")
    for _, bucket := range result.Buckets {
        fmt.Println("-", *bucket.Name)
    }
}