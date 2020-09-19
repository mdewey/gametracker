package com.metagametheory.gametracker.assemblers;


import com.metagametheory.gametracker.models.Campaign;
import com.metagametheory.gametracker.controllers.CampaignController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CampaignModelAssembler implements RepresentationModelAssembler<Campaign, EntityModel<Campaign>> {

    @Override
    public EntityModel<Campaign> toModel(Campaign entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(CampaignController.class).findOne(entity.getId())).withSelfRel(),
                linkTo(methodOn(CampaignController.class).all()).withRel("campaigns"));
    }
}
