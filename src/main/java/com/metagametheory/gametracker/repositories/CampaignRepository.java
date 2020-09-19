package com.metagametheory.gametracker.repositories;

import com.metagametheory.gametracker.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long>
{
}
