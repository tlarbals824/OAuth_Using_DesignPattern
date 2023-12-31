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
public class KakaoOAuthObserver extends AbstractOAuthObserver {
    private static final Provider PROVIDER = Provider.KAKAO;
    private final RestTemplate restTemplate;

    @Override
    protected OAuthUserInfo attemptLogin(String accessToken) {
        log.info("KakaoOAuthObserver attemptLogin");
        return new OAuthUserInfo("Kakao username","Kakao email");
    }

    @Override
    public boolean isLogin(Provider provider) {
        log.info("KakaoOAuthObserver isLogin");
        return PROVIDER.equals(provider);
    }
}
