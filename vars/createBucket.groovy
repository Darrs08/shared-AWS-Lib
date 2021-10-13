def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:"createbucket", 
          changeSet:'myset', 
          url:'https://filesdarren.s3.amazonaws.com/createBucket.yml'
        )
        cfnExecuteChangeSet(
          stack:"createbucket", 
          changeSet:'myset'
        )
  }
}
