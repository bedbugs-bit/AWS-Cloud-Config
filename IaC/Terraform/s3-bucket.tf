terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

resource "aws_s3_bucket" "my_bucket" {
  bucket = "${var.bucket_name}-${random_id.suffix.hex}"
}

resource "random_id" "suffix" {
  byte_length = 4
}

variable "aws_region" {
  description = "AWS region"
  default     = "us-west-2"
}

variable "bucket_name" {
  description = "Base name for S3 bucket"
  default     = "my-terraform-bucket"
}

output "bucket_name" {
  value = aws_s3_bucket.my_bucket.bucket
}