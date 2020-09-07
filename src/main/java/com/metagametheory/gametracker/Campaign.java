package com.metagametheory.gametracker;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Campaign {

    private @Id @GeneratedValue  Long id;
    private String AdventurePath;
    private Date StartedOn;

    public Campaign() {}

    public Campaign(String ap, Date started){
        this.AdventurePath = ap;
        this.StartedOn = started;
    }

    public Long getId() {
        return id;
    }

    public String getAdventurePath() {
        return AdventurePath;
    }

    public Date getStartedOn() {
        return StartedOn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdventurePath(String adventurePath) {
        AdventurePath = adventurePath;
    }

    public void setStartedOn(Date startedOn) {
        StartedOn = startedOn;
    }
}
