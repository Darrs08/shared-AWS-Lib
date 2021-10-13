def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
        }
        stages {
             stage('Upload Templates') {                  
                steps { 
                   uploadTemplateS3(s3Bucket: "filesdarren")
                }
            } 
            stage('Create Bucket') {                  
                steps {
                    createBucket()
                }
            }
            stage('Create DynamoDB') {                  
                steps {
                    createDynamo()
                }
            }
            stage('Upload Files to S3') {                  
                steps {
                    uploadAllFileS3(s3Bucket:"sample-bucket-darren")
                }
            }
            stage('Copy Certain File from another S3') {                  
                steps {
                    copyFileS3(s3fromBucket:"testbucket-abigael", s3Bucket:"sample-bucket-darren")
                }
            }
            stage('Delete a file from S3 bucket') {                  
                steps {
                    deleteFileS3(s3Bucket: "sample-bucket-darren", pathName: "CertainFileSample.txt")
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    deployToEC2(stackName: "EC2Jenkins-Darren", s3Bucket: "filesdarren")
                }
            }
        }
    }
}
