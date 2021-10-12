def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {       
        s3Upload( 
            bucket: stageParams.s3Bucket,
            file: "CertainFileSample.txt"                       
        )
    }
}
//awsRegion: "us-east-1", s3Bucket: "testbucket-darren", certainFile: "
