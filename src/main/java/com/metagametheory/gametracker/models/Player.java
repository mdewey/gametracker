package com.metagametheory.gametracker.models;

import javax.persistence.*;

@Entity
public class Player {
    private @Id @GeneratedValue  Long id;
    private String name;
    private Integer initiative;
    private Integer perception;
    private Integer will;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initiative=" + initiative +
                ", perception=" + perception +
                ", will=" + will +
                ", campaign=" + campaign +
                '}';
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="campaign_id", nullable = false)
    private Campaign campaign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getPerception() {
        return perception;
    }

    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    public Integer getWill() {
        return will;
    }

    public void setWill(Integer will) {
        this.will = will;
    }

    public boolean hasCampaign() {
        return campaign != null && campaign.getId() > 0;
    }
}
