package com.mail.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.mail.MailUtil;

@RestController
public class EmailController {
	@GetMapping("/sendMail")
    public String sendMail() {
		MailUtil sendMail=new MailUtil();
		sendMail.sendEmail("kapilkokcha9@gmail.com", "", "", "testMail", "yes");
        return "done";
    }
}
