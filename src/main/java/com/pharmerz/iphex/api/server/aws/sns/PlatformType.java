package com.pharmerz.iphex.api.server.aws.sns;

/**
 * Created by ankurpathak on 04-05-2016.
 */
public  enum PlatformType {
    // Apple Push Notification Service
    APNS,
    // Sandbox version of Apple Push Notification Service
    APNS_SANDBOX,
    // Amazon Device Messaging
    ADM,
    // Google Cloud Messaging
    GCM,
    // Baidu CloudMessaging Service
    BAIDU,
    // Windows Notification Service
    WNS,
    // Microsoft Push Notificaion Service
    MPNS;
}