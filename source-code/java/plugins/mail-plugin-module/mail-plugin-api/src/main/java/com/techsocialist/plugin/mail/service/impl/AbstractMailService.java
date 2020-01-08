package com.techsocialist.plugin.mail.service.impl;

import com.techsocialist.plugin.mail.service.api.IMailService;

public abstract class AbstractMailService implements IMailService {

    @Override
    public void sendMail(String from, String to, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, null, null, null, subject, message);
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, ccs, null, null, subject, message);
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String[] bccs, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, ccs, bccs, null, subject, message);
    }
}
