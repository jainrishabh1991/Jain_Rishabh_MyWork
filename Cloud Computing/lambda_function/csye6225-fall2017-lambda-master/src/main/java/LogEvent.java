import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class LogEvent implements RequestHandler<SNSEvent, Object> {

  private DynamoDB dynamo;
  private String tableName = "csye6225";
  private Regions region = Regions.US_EAST_1;
  static final String from = "noreply@csye6225-fall2017-jainrish.me";
  static final String subject = "Reset password reset link";
  static final String body = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
          + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
          + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
          + "AWS SDK for Java</a>";

  private String textBody;

  public Object handleRequest(SNSEvent request, Context context) {

    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());

    context.getLogger().log("Invocation started: " + timeStamp);

    context.getLogger().log("1: " + (request == null));

    context.getLogger().log("2: " + (request.getRecords().size()));

    context.getLogger().log(request.getRecords().get(0).getSNS().getMessage());

    timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());

    context.getLogger().log("Invocation completed: " + timeStamp);

    String email = request.getRecords().get(0).getSNS().getMessage();
    String token = UUID.randomUUID().toString();
    this.initDynamoDbClient();
    this.dynamo.getTable(tableName)
            .putItem(
                    new PutItemSpec().withItem(new Item()
                            .withString("id", email)
                            .withString("token", token)
                            .withInt("TTL", 1200)));
    textBody = "https://csye6225-fall2017.com/reset?email="+email+"&token="+token;
    try {
      AmazonSimpleEmailService amazonSimpleEmailServiceclient = AmazonSimpleEmailServiceClientBuilder.standard()
              .withRegion(Regions.US_EAST_1).build();
      SendEmailRequest sendEmailRequest = new SendEmailRequest()
              .withDestination(
                      new Destination().withToAddresses(email))
              .withMessage(new Message()
                      .withBody(new Body()
                              .withHtml(new Content()
                                      .withCharset("UTF-8").withData(body))
                              .withText(new Content()
                                      .withCharset("UTF-8").withData(textBody)))
                      .withSubject(new Content()
                              .withCharset("UTF-8").withData(subject)))
              .withSource(from);
      amazonSimpleEmailServiceclient.sendEmail(sendEmailRequest);
      System.out.println("Email sent successfully!");
    } catch (Exception ex) {
      System.out.println("Sorry. Unable to send the email: "
              + ex.getMessage());
    }
    return null;
  }

  private void initDynamoDbClient() {
    String access_key=System.getProperty("Access_Key");
    String secret_key=System.getProperty("Secret_Key");
    AmazonDynamoDBClient client = new AmazonDynamoDBClient(new BasicAWSCredentials(access_key, secret_key));
    client.setRegion(Region.getRegion(region));
    this.dynamo = new DynamoDB(client);
  }


}


