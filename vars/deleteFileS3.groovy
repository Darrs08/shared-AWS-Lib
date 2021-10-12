def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-darren"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {       
        s3Delete( 
            bucket: stageParams.s3Bucket 
            path: "HelloWorld.txt",                       
        )
    }
}
