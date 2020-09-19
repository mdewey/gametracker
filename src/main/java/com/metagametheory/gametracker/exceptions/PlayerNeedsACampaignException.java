package com.metagametheory.gametracker.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PlayerNeedsACampaignException extends RuntimeException {

    public PlayerNeedsACampaignException() {
        super("Every player needs a campaign");
    }
}