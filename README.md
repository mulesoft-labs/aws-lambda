# AWS Lambda Connector - Mule 4.x

> :exclamation: **MuleSoft has released a productized version of the AWS Lambda Connector. You can find it in Anypoint Exchange [here](https://anypoint.mulesoft.com/exchange/com.mulesoft.connectors/mule4-amazon-lambda-connector).**

AWS Lambda is an event-driven, serverless computing platform provided by Amazon as a part of Amazon Web Services. It is a computing service that runs code in response to events and automatically manages the computing resources required by that code.

### Instructions

1.  Clone the Repo
2.  Change the pom.xml groupId to match your organization id in your Anypoint Platform organization
3.  Deploy the connector to your [Exchange using Maven](https://docs.mulesoft.com/exchange/to-publish-assets-maven):  mvn clean -DskipTests deploy
4.  Consume connector in Anypoint Studio by downloading from Exchange.

## Reporting Issues

You can report new issues at this link https://github.com/djuang1/aws-lambda/issues.