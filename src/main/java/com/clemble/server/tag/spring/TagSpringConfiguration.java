package com.clemble.server.tag.spring;

import com.clemble.casino.server.player.notification.ServerNotificationService;
import com.clemble.casino.server.spring.common.CommonSpringConfiguration;
import com.clemble.casino.server.spring.common.MongoSpringConfiguration;
import com.clemble.casino.server.spring.common.SpringConfiguration;
import com.clemble.server.tag.controller.PlayerTagController;
import com.clemble.server.tag.listener.TagSystemGoalReachedEventListener;
import com.clemble.server.tag.listener.TagSystemPlayerCreatedEventListener;
import com.clemble.server.tag.repository.ServerPlayerTagsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

/**
 * Created by mavarazy on 2/3/15.
 */
@Configuration
@Import({CommonSpringConfiguration.class, MongoSpringConfiguration.class})
public class TagSpringConfiguration implements SpringConfiguration {

    @Bean
    public ServerPlayerTagsRepository serverPlayerTagsRepository(MongoRepositoryFactory repositoryFactory) {
        return repositoryFactory.getRepository(ServerPlayerTagsRepository.class);
    }

    @Bean
    public PlayerTagController clembleTagServiceController(ServerPlayerTagsRepository tagsRepository) {
        return new PlayerTagController(tagsRepository);
    }

    @Bean
    public TagSystemPlayerCreatedEventListener tagSystemPlayerCreatedEventListener(
        ServerPlayerTagsRepository tagsRepository
    ) {
        TagSystemPlayerCreatedEventListener tagCreationListener = new TagSystemPlayerCreatedEventListener(tagsRepository);
        return tagCreationListener;
    }

    @Bean
    public TagSystemGoalReachedEventListener tagSystemGoalReachedEventListener(
        @Qualifier("playerNotificationService") ServerNotificationService notificationService,
        ServerPlayerTagsRepository tagsRepository
    ) {
        TagSystemGoalReachedEventListener tagGoalReachedEventListener = new TagSystemGoalReachedEventListener(tagsRepository, notificationService);
        return tagGoalReachedEventListener;
    }

}
