package com.metagametheory.gametracker.advices;

import com.metagametheory.gametracker.exceptions.CampaignNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CampaignNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CampaignNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandle(CampaignNotFoundException ex){
        return ex.getMessage();
    }
}
