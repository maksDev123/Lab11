package com.example.MailJet;

import java.util.ArrayList;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

public class MailBox {
    private ArrayList<MailInfo> infos;
    public void sendAll() throws MailjetException, MailjetSocketTimeoutException{
        for(MailInfo info: this.infos){
            MailSender.sendMail(info);
        }
    }
    public void addMailInfo(MailInfo info){
        this.infos.add(info);
    }
}
