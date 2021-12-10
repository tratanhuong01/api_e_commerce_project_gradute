package com.api.api_e_commerce_project_gradute.DTO;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendPhone {
    public static final String ACCOUNT_SID = "AC17c314b390c0dfc4cb9ea4bcd18fbb36";
    public static final String AUTH_TOKEN = "d743a584f94fa3f47202919494c0d9f4";

    public String sendCodePhone(String phone) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phone),
                        new com.twilio.type.PhoneNumber("+17163254968"),
                        "1235678")
                .create();
        return message.getSid();
    }
}
