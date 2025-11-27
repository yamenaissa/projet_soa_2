package com.eya.usersmicroservices.util;

public interface EmailSender {
    void sendEmail(String toEmail, String body);

}
