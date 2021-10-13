def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:"${stageParams.stackName}", 
          changeSet:'my-change-set', 
          url:'https://testbucket-darren.s3.amazonaws.com/deployEC2.yml'
        )
        cfnExecuteChangeSet(
          stack:"${stageParams.stackName}", 
          changeSet:'my-change-set'
        )
  }
}
