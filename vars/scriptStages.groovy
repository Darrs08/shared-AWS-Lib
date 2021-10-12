def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadTemplateS3(s3Bucket:"testbucket-darren")
                }
            }
            stage('Upload File to S3') {                  
                steps {
                    uploadFileS3(awsRegion:"us-east-1", s3Bucket:"testbucket-darren")
                }
            }
            stage('Delete HelloWorld.txt from S3 bucket') {                  
                steps {
                    deleteFileS3(awsRegion: "us-east-1", s3Bucket: "testbucket-darren", pathName: "HelloWorld.txt")
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    deployToEC2()
                }
            }
        }
    }
}
