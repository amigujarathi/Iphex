package com.pharmerz.iphex.api.server.aws.sns;

/**
 * Created by ankurpathak on 03-05-2016.
 */
public class Main {
    public static void main(String[] args) {
        //AmazonSNSClient snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());
        //snsClient.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));

       // AmazonSNSClient snsClient1 = new AmazonSNSClient(new BasicAWSCredentials("AKIAIQOC7YNXHLQUM5HQ","S2e4CwxUaZJZcFbEIoK515P7/0dCtPErYQZfNuig"));
       // snsClient1.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));


       // CreateTopicRequest createTopicRequest = new CreateTopicRequest("MyTopic");

       // CreateTopicResult createTopicResult = snsClient.createTopic(createTopicRequest);

       // System.out.println(createTopicResult);
         //get request id for CreateTopicRequest from SNS metadata
       // System.out.println("CreateTopicRequest - " + snsClient.getCachedResponseMetadata(createTopicRequest));

      //   String topicArn = "arn:aws:sns:ap-southeast-1:181421870172:MyTopic";




        //SubscribeRequest subRequest = new SubscribeRequest(topicArn, "email", "ankur.pathak@pharmerz.com");
        //snsClient.subscribe(subRequest);
//get request id for SubscribeRequest from SNS metadata
       //System.out.println("SubscribeRequest - " + snsClient.getCachedResponseMetadata(subRequest));
        //System.out.println("Check your email and confirm subscription.");


        //String msg = "My text published to SNS topic with email endpoint";
        //PublishRequest publishRequest = new PublishRequest(topicArn, msg);
        //PublishResult publishResult = snsClient.publish(publishRequest);
//print MessageId of message published to SNS topic
        //System.out.println("MessageId - " + publishResult.getMessageId());


      /*  UnsubscribeRequest unSubRequest = new UnsubscribeRequest("arn:aws:sns:ap-southeast-1:181421870172:MyTopic:d5ad5045-435a-4f39-8e20-dfe58d8c3728");
        snsClient.unsubscribe(unSubRequest);

        System.out.println("UnsubscribeResponse - " + snsClient.getCachedResponseMetadata(unSubRequest));
*/


        //delete an SNS topic
       // DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
      //  snsClient.deleteTopic(deleteTopicRequest);
//get request id for DeleteTopicRequest from SNS metadata
       // System.out.println("DeleteTopicRequest - " + snsClient.getCachedResponseMetadata(deleteTopicRequest));




    }
}
