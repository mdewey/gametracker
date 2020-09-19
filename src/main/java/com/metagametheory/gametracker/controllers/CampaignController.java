package com.metagametheory.gametracker.controllers;


import com.metagametheory.gametracker.models.Campaign;
import com.metagametheory.gametracker.models.Player;
import com.metagametheory.gametracker.repositories.CampaignRepository;
import com.metagametheory.gametracker.assemblers.CampaignModelAssembler;
import com.metagametheory.gametracker.exceptions.CampaignNotFoundException;
import com.metagametheory.gametracker.repositories.PlayerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CampaignController {
    private final CampaignRepository repository;
    private final CampaignModelAssembler assembler;
    private final PlayerRepository playerRepository;

    CampaignController(CampaignRepository repository, CampaignModelAssembler assembler, PlayerRepository playerRepository){
        this.repository = repository;
        this.assembler = assembler;
        this.playerRepository = playerRepository;
    }


    @GetMapping("/campaigns")
   public  List< EntityModel<Campaign>> all(){
        var campaigns =  repository.findAll(Sort.by(Sort.Direction.DESC, "AdventurePath"));
        return campaigns.stream().map(assembler::toModel).collect(Collectors.toList());
    }

    @GetMapping("/campaigns/{id}")
    public EntityModel<Campaign> findOne(@PathVariable Long id){
        var campaign =  repository.findById(id).orElseThrow(() -> new CampaignNotFoundException(id));
      return assembler.toModel(campaign);
    }

    @PostMapping("/campaigns")
    EntityModel<Campaign>  create(@RequestBody Campaign campaign){
        return assembler.toModel(repository.save(campaign));
    }

    @PostMapping("/campaigns/{id}/players")
    EntityModel<Campaign>  create(@PathVariable Long id, @RequestBody Player player){
        var campaign = repository
                    .findById(id)
                    .orElseThrow(() -> new CampaignNotFoundException(id));
        player.setCampaign(campaign);
        this.playerRepository.save(player);
        campaign.addPlayer(player);
        return assembler.toModel(campaign);
    }

    @PutMapping("/campaigns/{id}")
    EntityModel<Campaign>  update(@RequestBody Campaign newDetails, @PathVariable Long id){
        var rv =  repository.findById(id).map(campaign -> {
            campaign.setAdventurePath(newDetails.getAdventurePath());
            campaign.setStartedOn(newDetails.getStartedOn());
            return repository.save(campaign);
        }).orElseThrow(() -> new CampaignNotFoundException(id));
        return assembler.toModel(rv);
    }

    @DeleteMapping("/campaigns/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }



}
