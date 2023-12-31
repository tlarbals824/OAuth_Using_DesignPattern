package com.sim.factorypattern.observer.observer.impl;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.observer.AbstractOAuthObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverOAuthObserver extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.NAVER;
    private final RestTemplate restTemplate;
    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("NaverOAuthObserver attemptLogin");
        return new OAuthUserInfo("Naver username","Naver email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("NaverOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
