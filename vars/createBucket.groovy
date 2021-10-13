def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:"createbucket", 
          changeSet:'myset', 
          url:'https://testbucket-darren.s3.amazonaws.com/deployBucket.yml'
        )
        cfnExecuteChangeSet(
          stack:"createbucket", 
          changeSet:'myset'
        )
  }
}
