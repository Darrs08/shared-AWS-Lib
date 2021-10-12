def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:'EC2Jenkins-Darren', 
          changeSet:'my-change-set', 
          url:'https://testbucket-darren.s3.amazonaws.com/deployEC2.yml'
        )
        cfnExecuteChangeSet(
          stack:'EC2Jenkins-Darren', 
          changeSet:'my-change-set'
        )
  }
}
