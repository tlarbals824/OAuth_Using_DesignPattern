package com.sim.factorypattern.service;

import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.dto.OAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final com.sim.factorypattern.factory.OAuthFactory OAuthFactory;

    public OAuthResponse oAuthLogin(Provider provider, String accessToken){
        return OAuthFactory.login(provider, accessToken);
    }
}
