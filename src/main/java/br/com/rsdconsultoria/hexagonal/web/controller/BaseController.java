package br.com.rsdconsultoria.hexagonal.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class BaseController {
    @Autowired
    private MessageSource messageSource;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getMessage(String message, String countryCode) {
        return messageSource.getMessage(message, null,
                new Locale((countryCode != null ? countryCode : "").toUpperCase(),
                        (countryCode != null ? countryCode : "").toLowerCase()));
    }
}
