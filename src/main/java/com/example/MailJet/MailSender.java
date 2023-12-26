package com.example.MailJet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

public class MailSender {
    private static String PrivaKey = "";
    private static String SecretKey = "";

    public static String greetingType(int MailCode) {
        if (MailCode == 1) {
            return "Good Morning";
        } else if (MailCode == 2) {
            return "Hey";
        } else {
            return "Hello";
        }
    }

    public static void sendMail(MailInfo info) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient(PrivaKey, SecretKey, new ClientOptions("v3.1"));
        String greetingString = greetingType(info.MailCode);

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", info.client.getEmail())
                                        .put("Name", info.client.getName()))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", info.client.getEmail())
                                                .put("Name", info.client.getName())))
                                .put(Emailv31.Message.SUBJECT, "Task 2")
                                .put(Emailv31.Message.TEXTPART,
                                        "You are Client" + info.client.getAge() + " " + info.client.getSex() + " "
                                                + info.client.getName())
                                .put(Emailv31.Message.HTMLPART, "<h3>+" + greetingString + " + " + info.client.getName()
                                        + ", welcome to task 2, visit Google page <a href='https://www.google.co.uk/'>Google</a>!</h3><br />")
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));

        response = client.post(request);

        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
