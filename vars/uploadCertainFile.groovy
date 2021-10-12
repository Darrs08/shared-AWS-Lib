def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-darren", certainFile: ""]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {       
        s3Upload( 
            bucket: stageParams.s3Bucket,
            file: "CertainFileSample.txt"                       
        )
    }
}
