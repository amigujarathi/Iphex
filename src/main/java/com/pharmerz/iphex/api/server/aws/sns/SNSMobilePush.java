package com.pharmerz.iphex.api.server.aws.sns;

/*
 * Copyright 2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SNSMobilePush {

	@Autowired
	private AmazonSNSClientWrapper snsClientWrapper;

	public SNSMobilePush(AmazonSNS snsClient) {
		this.snsClientWrapper = new AmazonSNSClientWrapper(snsClient);
	}

	public static final Map<PlatformType, Map<String, MessageAttributeValue>> attributesMap = new HashMap<PlatformType, Map<String, MessageAttributeValue>>();
	static {
		attributesMap.put(PlatformType.ADM, null);
		attributesMap.put(PlatformType.GCM, null);
		attributesMap.put(PlatformType.APNS, null);
		attributesMap.put(PlatformType.APNS_SANDBOX, null);
		attributesMap.put(PlatformType.BAIDU, addBaiduNotificationAttributes());
		attributesMap.put(PlatformType.WNS, addWNSNotificationAttributes());
		attributesMap.put(PlatformType.MPNS, addMPNSNotificationAttributes());
	}

	public static void main(String[] args) throws IOException {
		/*
		 * TODO: Be sure to fill in your AWS access credentials in the
		 * AwsCredentials.properties file before you try to run this sample.
		 * http://aws.amazon.com/security-credentials
		 */
		//AmazonSNS sns = new AmazonSNSClient(new PropertiesCredentials(
		//		SNSMobilePush.class
		//
		// 				.getResourceAsStream("AwsCredentials.properties")));
		AmazonSNSClient sns = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());

		//sns.setEndpoint("https://sns.us-west-2.amazonaws.com");
		sns.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));
		System.out.println("===========================================\n");
		System.out.println("Getting Started with Amazon SNS");
		System.out.println("===========================================\n");
		try {
			SNSMobilePush sample = new SNSMobilePush(sns);
			/* TODO: Uncomment the services you wish to use. */
			// sample.demoAppleSandboxAppNotification();
			// sample.demoKindleAppNotification();
			// sample.demoAppleAppNotification();
			// sample.demoAppleSandboxAppNotification();
			// sample.demoBaiduAppNotification();
			// sample.demoWNSAppNotification();
			// sample.demoMPNSAppNotification();
			//sample.demoAppleSandboxAppNotification();
			//sample.demoAndroidAppNotification();
			//sample.demoAppleAppNotification();
		} catch (AmazonServiceException ase) {
			System.out
					.println("Caught an AmazonServiceException, which means your request made it "
							+ "to Amazon SNS, but was rejected with an error response for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out
					.println("Caught an AmazonClientException, which means the client encountered "
							+ "a serious internal problem while trying to communicate with SNS, such as not "
							+ "being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

	public void androidAppNotification(String serverAPIKey, String applicationName, String registrationId, Map<String, String> message) {
		snsClientWrapper.notification(PlatformType.GCM, "", serverAPIKey,
				registrationId, applicationName, attributesMap, message);
	}

	public void kindleAppNotification(String clientId, String clientSecret, String applicationName, String registrationId, Map<String, String> message) {
		snsClientWrapper.notification(PlatformType.ADM, clientId, clientSecret,
				registrationId, applicationName, attributesMap, message);
	}

	public void appleAppNotification(String certificate, String privateKey, String applicationName, String deviceToken, Map<String, String> message) {
		snsClientWrapper.notification(PlatformType.APNS, certificate,
				privateKey, deviceToken, applicationName, attributesMap, message);
	}

	public void appleSandboxAppNotification(String certificate, String privateKey, String applicationName, String deviceToken, Map<String, String> message) {
		snsClientWrapper.notification(PlatformType.APNS_SANDBOX, certificate,
				privateKey, deviceToken, applicationName, attributesMap, message);
	}



	public void demoAppleSandboxAppNotification() {
		// TODO: Please fill in following values for your application. You can
		// also change the notification payload as per your preferences using
		// the method
		// com.amazonaws.sns.samples.tools.SampleMessageGenerator.getSampleAppleMessage()
		/*
		String certificate = "-----BEGIN CERTIFICATE-----\n" +
				"MIIFnTCCBIWgAwIBAgIIUsCxvWKfQ+4wDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV\n" +
				"BAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3Js\n" +
				"ZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3\n" +
				"aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkw\n" +
				"HhcNMTYwOTIxMTI1MDM5WhcNMTcwOTIxMTI1MDM5WjCBnDEsMCoGCgmSJomT8ixk\n" +
				"AQEMHGNvbS5qYWlkZWVwLnB1c2hOb3RpZmljYXRpb24xSjBIBgNVBAMMQUFwcGxl\n" +
				"IERldmVsb3BtZW50IElPUyBQdXNoIFNlcnZpY2VzOiBjb20uamFpZGVlcC5wdXNo\n" +
				"Tm90aWZpY2F0aW9uMRMwEQYDVQQLDApYVzlONTM1SDlFMQswCQYDVQQGEwJVUzCC\n" +
				"ASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBANTug3rga1wKLTUMJqfROv5/\n" +
				"HqCxurOfEMIFg7W/7+U3D5pS33JYuM7Uj3v0EcZKg/cZ8jrvCIvY965rcjYdqLGo\n" +
				"016MNfxXCNHFHOn8V/ob5Pp3BCLi4q3nkcUDjopld26Aa6TXEGaG9yIvk7VVzKH2\n" +
				"FcXBfD4ObjmE/FKxXVsdWH/vA0Aau3UWtQKxgc05UcmMpwGbbuZ84hQ0eF12a2nc\n" +
				"b/nb4iZrXIF0j2Y/tsFdGk4sd5Tcc4QHk3Ar1+UtLKVU0dOkj2K6KTgVnnMcIjwj\n" +
				"KpZmbBXxRaRiA5zAuocIP6ArYV+S6Y8HusOUj8DZEDdGYDwsrMGuvPxp6xLFzjkC\n" +
				"AwEAAaOCAeUwggHhMB0GA1UdDgQWBBQbC9h4lYu/mVRHkI3cZhrOERgM5DAJBgNV\n" +
				"HRMEAjAAMB8GA1UdIwQYMBaAFIgnFwmpthhgi+zruvZHWcVSVKO3MIIBDwYDVR0g\n" +
				"BIIBBjCCAQIwgf8GCSqGSIb3Y2QFATCB8TCBwwYIKwYBBQUHAgIwgbYMgbNSZWxp\n" +
				"YW5jZSBvbiB0aGlzIGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1bWVzIGFj\n" +
				"Y2VwdGFuY2Ugb2YgdGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0ZXJtcyBh\n" +
				"bmQgY29uZGl0aW9ucyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBhbmQgY2Vy\n" +
				"dGlmaWNhdGlvbiBwcmFjdGljZSBzdGF0ZW1lbnRzLjApBggrBgEFBQcCARYdaHR0\n" +
				"cDovL3d3dy5hcHBsZS5jb20vYXBwbGVjYS8wTQYDVR0fBEYwRDBCoECgPoY8aHR0\n" +
				"cDovL2RldmVsb3Blci5hcHBsZS5jb20vY2VydGlmaWNhdGlvbmF1dGhvcml0eS93\n" +
				"d2RyY2EuY3JsMAsGA1UdDwQEAwIHgDATBgNVHSUEDDAKBggrBgEFBQcDAjAQBgoq\n" +
				"hkiG92NkBgMBBAIFADANBgkqhkiG9w0BAQUFAAOCAQEAHIW582VWw4TgmrMy7g01\n" +
				"RvW+bsdGo12CZ6Hxl4GKtYh234oISj8HV/R4wtCLykjXJpWeXWuxcMqe28+BjQa1\n" +
				"nvdhAoWVWEwgqhmAI4Sb9uVhIHKQMZLhKCVsMs7YRZrevwjEqSCGAo4BPyenVWgl\n" +
				"xKYeLvo6KgYKd4X33frD81E3vWGG+u/otYwu238jDxSOmNMT4xGMksR9VBmZgb9r\n" +
				"bkbEEXfJpMWPiAWkERtu5PU4xQT16lSU0K8CczGVsDjXNNqODOzqXNpCqyMeeJs7\n" +
				"8oqjv9rqF1MzeOWyf30V1/yDh0u0Gx/RCI09Z0kXsEsuxyUQHB3hEebL9pBySSL8\n" +
				"eQ==\n" +
				"-----END CERTIFICATE-----"; // This should be in pem format with \n at the
									// end of each line.
		String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
				"MIIEpQIBAAKCAQEA1O6DeuBrXAotNQwmp9E6/n8eoLG6s58QwgWDtb/v5TcPmlLf\n" +
				"cli4ztSPe/QRxkqD9xnyOu8Ii9j3rmtyNh2osajTXow1/FcI0cUc6fxX+hvk+ncE\n" +
				"IuLireeRxQOOimV3boBrpNcQZob3Ii+TtVXMofYVxcF8Pg5uOYT8UrFdWx1Yf+8D\n" +
				"QBq7dRa1ArGBzTlRyYynAZtu5nziFDR4XXZradxv+dviJmtcgXSPZj+2wV0aTix3\n" +
				"lNxzhAeTcCvX5S0spVTR06SPYropOBWecxwiPCMqlmZsFfFFpGIDnMC6hwg/oCth\n" +
				"X5Lpjwe6w5SPwNkQN0ZgPCyswa68/GnrEsXOOQIDAQABAoIBAFzO/QXQzVqXoO6v\n" +
				"NiYNP05v79SQwtTJrw8yQh804oYgwq88EeKQIzUbVtLrJdgs4GoSqA7h4vK5hfND\n" +
				"J8vIj5+n+0EJkfpDoTd1V83wzBPalqpIt8fQ5oZwGYwqqbVO1oiWdtSpXJ+jkhIX\n" +
				"dKUkGYY6cXD5jYKq3YY6nZQZdJxiWUDY3bcXHbMHvzt458zI7wxLRdOa8bahAv6H\n" +
				"0prsD4WDI3GErlgjTvi7JgubrsbOG9c+HhUgPbQ671KD3b1yq0kwEb8I2ulq7Xsi\n" +
				"9fvwM6C76Tg0FQN0UTz5tPd3E7NR5UcTXWINwyorpPqjzSV57lLCq5u1vDEj2w5S\n" +
				"HaYETvUCgYEA9jerA8MTBg5ZiDKSsbe6mI4cPN6L1knsCfUdAlyi6V3cpvs/Qk51\n" +
				"RRfJXnALD2CEQ64w+zUnF6LZga/jvnxnZiZRoA6yDotbw7I0iW5p+aGHbUIUD1cu\n" +
				"ocbPDs0V4+sz0vW5Q2liv9AVc4zlRU4txD+Jjp/sqlvuOcS7tcOdh6MCgYEA3WRJ\n" +
				"7QJVKQTcXEqxT/4dkV350bP/KC2ORodUm4nXK2NT/h2TECqKWV9zcMhN/rVzEaL8\n" +
				"Kf4pttuXRP3rstYPiQAEfEvo7GIOsHZ4NR8GUNpZsJ7GhFyGUcw3Ebrm5nfJxbHa\n" +
				"AnQYHbOX3jZK2LDIv2tP0cb4CUpWNluQGJyUoHMCgYEA0ZKKnvYhMCtwq8wYLurr\n" +
				"CcUUZf8rWaesIMGhAoylIiwBj6QVsTOk/72Caj7GOz1090LCcGBKuQSlTIzRNicf\n" +
				"v8PoAGvhxR17azQ5Ia14yMFjy2zONEyJ5auaPMf11P0zLGJ5YdbG9euBBsyrrfUg\n" +
				"YYWPaXXYdR0wxb0d5VXutS8CgYEAq2YjXZy6taEPwVwKXnXMCmkJKfMCjeaHCc9o\n" +
				"D2rt7KdftZLL8m4c4ghl5WEOES4FQhg+xXwCa5EiUcWMHs5fBJ/A2UIjuC5KVQ/D\n" +
				"DM1SJHKHkZe69Wp0iwthbxaWAMOosKd6sv+SVBxgbSb3Vz+2i4vXJf+2s+qbSEYn\n" +
				"DwbagkUCgYEA191vSM+Haxj4slihN9owvhmt/DGCNuUyS8w7y1t90zX8yvs3/HYY\n" +
				"eJy4kJ7ljq7se14O08C+A2Y9upS+midZ+Ad+yygz/Y9+jh2qJd5ojhatgPpQKzVU\n" +
				"BftrgnAWaUeck5P4E7Oe8fBUwbQB9nxS8X2pqvt0fLlSulOZztsCa44=\n" +
				"-----END RSA PRIVATE KEY-----";	// end of each line.
		String applicationName = "pushNotification";
		String deviceToken = "e842d4f2fd99b7fd0397476d2f0ddeef457af10eb912dd5c767a5b9c3f84bc83"; // This is 64 hex characters.
		*/
		String certificate = "-----BEGIN CERTIFICATE-----\n" +
				"MIIFkTCCBHmgAwIBAgIIIpOe8dh1TCEwDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV\n" +
				"BAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3Js\n" +
				"ZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3\n" +
				"aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkw\n" +
				"HhcNMTYxMDA0MTAzNjUzWhcNMTcxMDA0MTAzNjUzWjCBkDEmMCQGCgmSJomT8ixk\n" +
				"AQEMFmNvbS5qYWlkZWVwLk1LUy1QaHJhbWExRDBCBgNVBAMMO0FwcGxlIERldmVs\n" +
				"b3BtZW50IElPUyBQdXNoIFNlcnZpY2VzOiBjb20uamFpZGVlcC5NS1MtUGhyYW1h\n" +
				"MRMwEQYDVQQLDApYVzlONTM1SDlFMQswCQYDVQQGEwJVUzCCASIwDQYJKoZIhvcN\n" +
				"AQEBBQADggEPADCCAQoCggEBALRUdzCOEiDJxgkZIlbYv/+yEdtXgojvwpwQWMJ6\n" +
				"w69p2hdKI90r/Qb7cRywv82YO+j+8LBGmV0QIZ/+e4yDOQofxxWYFYti43gdl5W2\n" +
				"/NhyRI2sDjRaSsiA72Y/AB8mO8J0/TR3i5ZAr2cQvG0BJdvqK+NDhXbO4L5q/JZU\n" +
				"7wXX3i4EacyADaDVoGztwLlrY7av3p/ZxTi1buTX3Ou8I0uqc+IxWr2Oseuz0fbq\n" +
				"p5gzUGI2DcAvcyfS3AlOBS1OXj8/Mzd2LMiN2uBa1Vw2oLY8GTgJsF3oqua6v+Fy\n" +
				"+qWSbeaS3vsbcnKEK5yGRICoTAHWXOdPKJsOzT0O1KcrSxUCAwEAAaOCAeUwggHh\n" +
				"MB0GA1UdDgQWBBSW52kECV8uzkK1QKALwlU8HydsqjAJBgNVHRMEAjAAMB8GA1Ud\n" +
				"IwQYMBaAFIgnFwmpthhgi+zruvZHWcVSVKO3MIIBDwYDVR0gBIIBBjCCAQIwgf8G\n" +
				"CSqGSIb3Y2QFATCB8TCBwwYIKwYBBQUHAgIwgbYMgbNSZWxpYW5jZSBvbiB0aGlz\n" +
				"IGNlcnRpZmljYXRlIGJ5IGFueSBwYXJ0eSBhc3N1bWVzIGFjY2VwdGFuY2Ugb2Yg\n" +
				"dGhlIHRoZW4gYXBwbGljYWJsZSBzdGFuZGFyZCB0ZXJtcyBhbmQgY29uZGl0aW9u\n" +
				"cyBvZiB1c2UsIGNlcnRpZmljYXRlIHBvbGljeSBhbmQgY2VydGlmaWNhdGlvbiBw\n" +
				"cmFjdGljZSBzdGF0ZW1lbnRzLjApBggrBgEFBQcCARYdaHR0cDovL3d3dy5hcHBs\n" +
				"ZS5jb20vYXBwbGVjYS8wTQYDVR0fBEYwRDBCoECgPoY8aHR0cDovL2RldmVsb3Bl\n" +
				"ci5hcHBsZS5jb20vY2VydGlmaWNhdGlvbmF1dGhvcml0eS93d2RyY2EuY3JsMAsG\n" +
				"A1UdDwQEAwIHgDATBgNVHSUEDDAKBggrBgEFBQcDAjAQBgoqhkiG92NkBgMBBAIF\n" +
				"ADANBgkqhkiG9w0BAQUFAAOCAQEAijb5uDb3fdal0zZ75ZDixA9BPOWabfJs7wGK\n" +
				"56rPl2nrbPkEDJCrAl5Sd3sEk1f/iWHeqjZCFgY/iuhweyP4Ouw9hM/8ygEpyEX9\n" +
				"GkpE/3wLcHuIH/Ku+vh1sq3AkTTLNnSA8GDtNg4dFd0YhqAK7wvZUYZcrehEMw1p\n" +
				"vIAV+92O6DXAtcxL5Fim8QVHPEAV5pK0ZMshER/uXejY3ki2jUZMYh+VgeN2zVqq\n" +
				"8JXqFKTGRBd+dILXBkEgdxrahGekZ6HEg87DEWsHI9AjSYuZi7/1A7V6+D2Tm5m3\n" +
				"M8ENHIP7gjA84/JaGvfkJ2atYpqa4h3Noq+cBJnDnRMJOUDMbA==\n" +
				"-----END CERTIFICATE-----"; // This should be in pem format with \n at the
		// end of each line.
		String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
				"MIIEpAIBAAKCAQEAtFR3MI4SIMnGCRkiVti//7IR21eCiO/CnBBYwnrDr2naF0oj\n" +
				"3Sv9BvtxHLC/zZg76P7wsEaZXRAhn/57jIM5Ch/HFZgVi2LjeB2Xlbb82HJEjawO\n" +
				"NFpKyIDvZj8AHyY7wnT9NHeLlkCvZxC8bQEl2+or40OFds7gvmr8llTvBdfeLgRp\n" +
				"zIANoNWgbO3AuWtjtq/en9nFOLVu5Nfc67wjS6pz4jFavY6x67PR9uqnmDNQYjYN\n" +
				"wC9zJ9LcCU4FLU5ePz8zN3YsyI3a4FrVXDagtjwZOAmwXeiq5rq/4XL6pZJt5pLe\n" +
				"+xtycoQrnIZEgKhMAdZc508omw7NPQ7UpytLFQIDAQABAoIBAQCZsSOkjnGE4HOY\n" +
				"bYOG4VVCaFIvz3XBoBcNTCFaH6eIaX8nOlk2t7b/rG3LNhlC8OyeuCoLEyDC4GzI\n" +
				"H+zM5UpIBq13ChfSpIWaah43y63UDA/Bb1Lr68iw+rMPQcKoyb1FDtB/VyPw+1CD\n" +
				"VxBBFyldNUgSegnWKJwDrst4lQrivpqlXXp3OttEmLC6BjOdx4OUl9Bzcck+YHa3\n" +
				"sufc8E736j8+2SccpqWl21laIhPyjhzgxZWB/fofLXslfxRcVFUSyFRY20r7wBf6\n" +
				"fxQzBuNXhRK7hMxzg1fgoWUnyhWTX+4ui5WRdy4MQf+183xGRVVbc9WHWSx7wmqj\n" +
				"+nNTHB4BAoGBANn4/OyMctNV+ijMn6fmaXI2vYzPLgLGVZTYMyjwPdh8Q9tkRj/u\n" +
				"IZJsNdZlXqLwHvA4MEFisBdWCxzWH/ki3xTnNnBypYWUe6lCoHCyXzc5nvl7Cl2G\n" +
				"ucjFNcGCAhaJF4/cdSC9rC+l0SSqnSUyqDZ/j6S06X72LR4WzCpwS3sZAoGBANPK\n" +
				"S3fgHBo/xB+dtOse2sc0lT0oSq8WJv8eIB8xkxBTy4pMFn1XUdVNebur95qr4iVu\n" +
				"SG2DUg7C2/BkQ9rIeEzCApF8Emnwe2hF2D69z2PGMy+4yG9m1yBxxmD2I/p9Lcn0\n" +
				"JTQ+Zx+Vs1bENePcjJtokXCS+wVusde+6cD1UYtdAoGAMWdTvDGhHPFRv8mRLjb1\n" +
				"E2QA1ldm8E4Pu6q8/bxl6BlSL/msSnUous037p4PMxMFkCDMHyXFD6T649BMcuVK\n" +
				"dqxpFFeH2Jzs4lItlx12o0e2FomiscwFc9Hu+ysCWiU8Z+jpyz/yNOJ6Yrsg3vt6\n" +
				"UM/cuNIgUhxt4XH9WGkXUpECgYEA0OXeHnVdAr8WsaCajLc4T/ibo2EUmTIecNDE\n" +
				"GkCJsDcWsmhuXl88hkoO4n+ykEstmoH2yp4W2Bx3V9tt2mSV1BAg/GMGvpvG/Yi2\n" +
				"zNvnraAXaOC4QrmLQ6M1avodbrr96Q75i1hp2wuLgu+xv/kQb1Fq80Dme+s9W3Ih\n" +
				"moPeVLkCgYBvHvOGBIDtQxJTBrvn1DKUtTV6D4t3WHNpLbpgjQxLa5kotVA7HqWz\n" +
				"+YvrerD3qXJJi2/wsMHqc5LPsv76HmV/GDyaSZBKpJ+I32/a0aFozxGQoadfT845\n" +
				"j5t9bSHA1z7504N6eALZ4njxGOZBK8A0FOUSJRhttUWrvONkWuOX9Q==\n" +
				"-----END RSA PRIVATE KEY-----";	// end of each line.
		String applicationName = "MKSPharma";
		String deviceToken = "85c40b768f33481bcb16325df4e7c20d8743a9e509bee7a34cfc88b934ee753b"; // This is 64 hex characters.

		snsClientWrapper.notification(PlatformType.APNS_SANDBOX, certificate,
				privateKey, deviceToken, applicationName, attributesMap, new HashMap<>());
	}











	public void baiduAppNotification(String userId, String channelId, String apiKey, String secretKey, String applicationName, Map<String, String> message) {
		snsClientWrapper.notification(PlatformType.BAIDU, apiKey, secretKey,
				channelId + "|" + userId, applicationName, attributesMap, message);
	}

	public void wnsAppNotification(String notificationChannelURI,
			String packageSecurityIdentifier,
			String secretKey,
			String applicationName,
		    Map<String, String> message
	) {
		snsClientWrapper.notification(PlatformType.WNS,
				packageSecurityIdentifier, secretKey, notificationChannelURI,
				applicationName, attributesMap, message);
	}

	public void mpnsAppNotification(String notificationChannelURI,
			String applicationName,
			Map<String, String> message
	) {
		snsClientWrapper.notification(PlatformType.MPNS, "", "",
				notificationChannelURI, applicationName, attributesMap, message);
	}

	private static Map<String, MessageAttributeValue> addBaiduNotificationAttributes() {
		Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
		notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.DeployStatus",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("1"));
		notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.MessageKey",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("default-channel-msg-key"));
		notificationAttributes.put("AWS.SNS.MOBILE.BAIDU.MessageType",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("0"));
		return notificationAttributes;
	}

	private static Map<String, MessageAttributeValue> addWNSNotificationAttributes() {
		Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
		notificationAttributes.put("AWS.SNS.MOBILE.WNS.CachePolicy",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("cache"));
		notificationAttributes.put("AWS.SNS.MOBILE.WNS.Type",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("wns/badge"));
		return notificationAttributes;
	}

	private static Map<String, MessageAttributeValue> addMPNSNotificationAttributes() {
		Map<String, MessageAttributeValue> notificationAttributes = new HashMap<String, MessageAttributeValue>();
		notificationAttributes.put("AWS.SNS.MOBILE.MPNS.Type",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("token")); // This attribute is required.
		notificationAttributes.put("AWS.SNS.MOBILE.MPNS.NotificationClass",
				new MessageAttributeValue().withDataType("String")
						.withStringValue("realtime")); // This attribute is required.
														
		return notificationAttributes;
	}
}
