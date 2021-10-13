def call(Map stageParams = [:]){
  withAWS(region:"${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:"createDynamoDB", 
          changeSet:'dynamo-set', 
          url:'https://filesdarren.s3.amazonaws.com/deployDynamoDB.yml'
        )
        cfnExecuteChangeSet(
          stack:"createDynamoDB", 
          changeSet:'dynamo-set'
        )
  }
}
