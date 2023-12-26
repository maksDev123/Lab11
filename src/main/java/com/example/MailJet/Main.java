package com.example.MailJet;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
public class Main {
  public static void main(String[] args) throws MailjetException, MailjetSocketTimeoutException {
    MailjetClient client;
    MailjetRequest request;
    MailjetResponse response;
    client = new MailjetClient("5a19c10af94e39180053ac7bee1266d7", "1f61545884a79bfb24410240d497e005", new ClientOptions("v3.1"));
    request = new MailjetRequest(Emailv31.resource)
    .property(Emailv31.MESSAGES, new JSONArray()
    .put(new JSONObject()
    .put(Emailv31.Message.FROM, new JSONObject()
    .put("Email", "maksym.buleshnyi.pn@ucu.edu.ua")
    .put("Name", "Maksym"))
    .put(Emailv31.Message.TO, new JSONArray()
    .put(new JSONObject()
    .put("Email", "maksym.buleshnyi.pn@ucu.edu.ua")
    .put("Name", "Maksym")))
    .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
    .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
    .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
    .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
    response = client.post(request);
    System.out.println(response.getStatus());
    System.out.println(response.getData());
  }
}
