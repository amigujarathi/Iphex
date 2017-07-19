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

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class AmazonSNSClientWrapper {

	private final AmazonSNS snsClient;

	@Autowired
	public AmazonSNSClientWrapper(AmazonSNS client) {
		this.snsClient = client;
	}

	private CreatePlatformApplicationResult createPlatformApplication(
			String applicationName, PlatformType platformType, String principal,
			String credential) {
		CreatePlatformApplicationRequest platformApplicationRequest = new CreatePlatformApplicationRequest();
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("PlatformPrincipal", principal);
		attributes.put("PlatformCredential", credential);
		platformApplicationRequest.setAttributes(attributes);
		platformApplicationRequest.setName(applicationName);
		platformApplicationRequest.setPlatform(platformType.name());
		return snsClient.createPlatformApplication(platformApplicationRequest);
	}

	private CreatePlatformEndpointResult createPlatformEndpoint(
			PlatformType platformType, String customData, String platformToken,
			String applicationArn) {
		CreatePlatformEndpointRequest platformEndpointRequest = new CreatePlatformEndpointRequest();
		platformEndpointRequest.setCustomUserData(customData);
		String token = platformToken;
		String userId = null;
		if (platformType == PlatformType.BAIDU) {
			String[] tokenBits = platformToken.split("\\|");
			token = tokenBits[0];
			userId = tokenBits[1];
			Map<String, String> endpointAttributes = new HashMap<String, String>();
			endpointAttributes.put("UserId", userId);
			endpointAttributes.put("ChannelId", token);
			platformEndpointRequest.setAttributes(endpointAttributes);
		}
		platformEndpointRequest.setToken(token);
		platformEndpointRequest.setPlatformApplicationArn(applicationArn);
		return snsClient.createPlatformEndpoint(platformEndpointRequest);
	}

	private void deletePlatformApplication(String applicationArn) {
		DeletePlatformApplicationRequest request = new DeletePlatformApplicationRequest();
		request.setPlatformApplicationArn(applicationArn);
		snsClient.deletePlatformApplication(request);
	}

	private PublishResult publish(String endpointArn, PlatformType platformType,
			Map<PlatformType, Map<String, MessageAttributeValue>> attributesMap, Map<String, String> message) {
		PublishRequest publishRequest = new PublishRequest();
		Map<String, MessageAttributeValue> notificationAttributes = getValidNotificationAttributes(attributesMap
				.get(platformType));
		if (notificationAttributes != null && !notificationAttributes.isEmpty()) {
			publishRequest.setMessageAttributes(notificationAttributes);
		}
		publishRequest.setMessageStructure("json");
		// If the message attributes are not set in the requisite method,
		// notification is sent with default attributes
		String messageString = getPlatformMessage(platformType, message);
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put(platformType.name(), messageString);
		messageString = MessageGenerator.jsonify(messageMap);
		// For direct publish to mobile end points, topicArn is not relevant.
		publishRequest.setTargetArn(endpointArn);

		// Display the message that will be sent to the endpoint/
		System.out.println("{Message Body: " + messageString + "}");
		StringBuilder builder = new StringBuilder();
		builder.append("{Message Attributes: ");
		for (Map.Entry<String, MessageAttributeValue> entry : notificationAttributes
				.entrySet()) {
			builder.append("(\"" + entry.getKey() + "\": \""
					+ entry.getValue().getStringValue() + "\"),");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("}");
		System.out.println(builder.toString());

		publishRequest.setMessage(messageString);
		return snsClient.publish(publishRequest);
	}

	public void notification(PlatformType platformType, String principal,
								 String credential, String platformToken, String applicationName,
								 Map<PlatformType, Map<String, MessageAttributeValue>> attrsMap, Map<String, String> message) {
		// Create PlatformType Application. This corresponds to an app on a
		// platformType.
		CreatePlatformApplicationResult platformApplicationResult = createPlatformApplication(
				applicationName, platformType, principal, credential);
		System.out.println(platformApplicationResult);

		// The PlatformType Application Arn can be used to uniquely identify the
		// PlatformType Application.
		String platformApplicationArn = platformApplicationResult
				.getPlatformApplicationArn();

		// Create an Endpoint. This corresponds to an app on a device.
		CreatePlatformEndpointResult platformEndpointResult = createPlatformEndpoint(
				platformType,
				"CustomData - Useful to store endpoint specific data",
				platformToken, platformApplicationArn);
		System.out.println(platformEndpointResult);

		// Publish a push notification to an Endpoint.
		PublishResult publishResult = publish(
				platformEndpointResult.getEndpointArn(), platformType, attrsMap, message);
		System.out.println("Published! \n{MessageId="
				+ publishResult.getMessageId() + "}");
		// Delete the PlatformType Application since we will no longer be using it.
		deletePlatformApplication(platformApplicationArn);

		//
	}

	private String getPlatformMessage(PlatformType platformType, Map<String, String> message) {
		switch (platformType) {
		case APNS:
			return MessageGenerator.getAppleMessage(message);
		case APNS_SANDBOX:
			return MessageGenerator.getAppleMessage(message);
		case GCM:
			return MessageGenerator.getAndroidMessage(message);
		case ADM:
			return MessageGenerator.getKindleMessage(message);
		case BAIDU:
			return MessageGenerator.getBaiduMessage(message);
		case WNS:
			return MessageGenerator.getWNSMessage(message);
		case MPNS:
			return MessageGenerator.getMPNSMessage(message);
		default:
			throw new IllegalArgumentException("PlatformType not supported : "
					+ platformType.name());
		}
	}

	public static Map<String, MessageAttributeValue> getValidNotificationAttributes(
			Map<String, MessageAttributeValue> notificationAttributes) {
		Map<String, MessageAttributeValue> validAttributes = new HashMap<String, MessageAttributeValue>();

		if (notificationAttributes == null) return validAttributes;

		for (Map.Entry<String, MessageAttributeValue> entry : notificationAttributes
				.entrySet()) {
			if (!StringUtils.isBlank(entry.getValue().getStringValue())) {
				validAttributes.put(entry.getKey(), entry.getValue());
			}
		}
		return validAttributes;
	}
}
