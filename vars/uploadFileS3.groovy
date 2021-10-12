def call(Map stageParams = [:]) {
    withAWS(region: ${stageParams.awsRegion}, credentials:"${AWS_CRED}") {       
        s3Upload( 
            includePathPattern: "**/*",
            bucket: ${stageParams.s3bucket}            
        )
    }
}
//awsRegion: "us-east-1", bucket: "testbucket-darren"
