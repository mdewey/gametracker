package com.metagametheory.gametracker;


import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CampaignController {
    private final CampaignRepository repository;

    CampaignController(CampaignRepository repository){
        this.repository = repository;
    }


    @GetMapping("/campaigns")
    List<Campaign> all(){
        return repository.findAll(Sort.by(Sort.Direction.DESC, "AdventurePath"));
    }
}
