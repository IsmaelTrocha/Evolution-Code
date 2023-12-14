package com.evolutioncode.technicaltest.shared.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

  @Autowired
  MessageSource messageSource;

  public String getMessage(String message, String... args) {
    return messageSource.getMessage(message,
        args, LocaleContextHolder.getLocale());
  }

}
