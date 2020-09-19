package com.metagametheory.gametracker.configuration;


import com.metagametheory.gametracker.models.Campaign;
import com.metagametheory.gametracker.repositories.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CampaignRepository repository){
        return args -> {
            log.info("Loading:" + repository.save(new Campaign("Rise of the Runelords", new Date())));
            log.info("Loading:" + repository.save(new Campaign("Serpents Skull", new Date())));
        };
    }

}
