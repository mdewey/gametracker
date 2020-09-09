package com.metagametheory.gametracker;

import org.springframework.data.jpa.repository.JpaRepository;

interface CampaignRepository extends JpaRepository<Campaign, Long>
{
}
