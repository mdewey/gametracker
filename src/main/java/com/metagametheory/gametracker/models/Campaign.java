package com.metagametheory.gametracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Campaign {

    private @Id @GeneratedValue Long id;
    private String adventurePath;
    private Date startedOn;

    public List<Player> getPlayers() {
        return players;
    }

    @OneToMany(mappedBy = "campaign")
    private List<Player> players;

    public Campaign() {}

    public Campaign(String ap, Date started){
        this.adventurePath = ap;
        this.startedOn = started;
    }

    public Long getId() {
        return id;
    }

    public String getAdventurePath() {
        return adventurePath;
    }

    public Date getStartedOn() {
        return startedOn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdventurePath(String adventurePath) {
        this.adventurePath = adventurePath;
    }

    public void setStartedOn(Date startedOn) {
        this.startedOn = startedOn;
    }
}
