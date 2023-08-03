package com.sim.factorypattern.config;

import com.sim.factorypattern.observer.AbstractOAuthObserver;
import com.sim.factorypattern.subject.AbstractOAuthSubject;
import com.sim.factorypattern.util.ApplicationContextUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Configuration
@DependsOn("applicationContextUtils")
public class OAuthConfig {


    @Bean
    public AbstractOAuthSubject abstractOAuthSubject(){
        AbstractOAuthSubject abstractOAuthSubject = new AbstractOAuthSubject();
        Map<String, AbstractOAuthObserver> oAuthObserverMap = getOAuthObserverMap();
        for (AbstractOAuthObserver oAuthObserver : oAuthObserverMap.values()) {
            abstractOAuthSubject.registerObserver(oAuthObserver);
        }
        return abstractOAuthSubject;
    }

    private Map<String, AbstractOAuthObserver> getOAuthObserverMap(){
        return ApplicationContextUtils.getBeanOfType(AbstractOAuthObserver.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
