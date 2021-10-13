def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:"createbucket", 
          changeSet:'my-change-set', 
          url:'https://github.com/Darrs08/JenkinsAWS-demo/blob/main/deployBucket.yml'
        )
        cfnExecuteChangeSet(
          stack:"createbucket", 
          changeSet:'my-change-set'
        )
  }
}
