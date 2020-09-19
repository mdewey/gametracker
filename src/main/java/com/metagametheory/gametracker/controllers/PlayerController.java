package com.metagametheory.gametracker.controllers;


import com.metagametheory.gametracker.configuration.LoadDatabase;
import com.metagametheory.gametracker.exceptions.PlayerNeedsACampaignException;
import com.metagametheory.gametracker.models.Player;
import com.metagametheory.gametracker.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    private PlayerRepository playerRepository;


    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public List<Player> all(){
        return playerRepository.findAll();
    }
    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);
    @PostMapping("/players")
    public Player create(@RequestBody Player player){
        log.info("got here: " + player);
        if(player.hasCampaign()) {
            return playerRepository.save(player);
        }
        else throw new PlayerNeedsACampaignException();

    }
}
