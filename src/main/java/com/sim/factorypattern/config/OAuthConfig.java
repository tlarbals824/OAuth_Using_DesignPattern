package com.sim.factorypattern.config;

import com.sim.factorypattern.observer.observer.AbstractOAuthObserver;
import com.sim.factorypattern.observer.subject.AbstractOAuthSubject;
import com.sim.factorypattern.util.ApplicationContextUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Map;

@Configuration
@DependsOn("applicationContextUtils")
public class OAuthConfig {


    @Bean
    public AbstractOAuthSubject abstractOAuthSubject(){
        final AbstractOAuthSubject abstractOAuthSubject = new AbstractOAuthSubject();
        Collection<AbstractOAuthObserver> oAuthObserverCollection = getOAuthObserverMap(AbstractOAuthObserver.class).values();
        for (AbstractOAuthObserver oAuthObserver : oAuthObserverCollection) {
            abstractOAuthSubject.registerObserver(oAuthObserver);
        }
//        final ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
//        abstractOAuthSubject.initObserver(applicationContext);
        return abstractOAuthSubject;
    }

    public <T> Map<String, T> getOAuthObserverMap(Class<T> clazz){
        return ApplicationContextUtils.getBeanOfType(clazz);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
