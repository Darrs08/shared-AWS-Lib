def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {       
        s3Upload( 
            fromBucket: stageParams.s3fromBucket,
            toBucket: stageParams.s3Bucket,
            fromPath: "src/HelloAbby.txt",                     
        )
    }
}
