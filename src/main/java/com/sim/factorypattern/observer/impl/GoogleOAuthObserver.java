package com.sim.factorypattern.observer.impl;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.AbstractOAuthObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleOAuthObserver  extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.GOOGLE;
    private final RestTemplate restTemplate;

    @Override
    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("GoogleOAuthObserver attemptLogin");
        return new OAuthUserInfo("Google username","Google email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("GoogleOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
