package com.sim.factorypattern.observer.observer;

import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.dto.Provider;
import com.sim.factorypattern.observer.subject.OAuth;

public abstract class AbstractOAuthObserver implements Observer<OAuth, OAuthUserInfo> {
    @Override
    public OAuthUserInfo accept(OAuth status) {
        return attemptLogin(status.getAccessToken());
    }

    protected abstract OAuthUserInfo attemptLogin(String accessToken);

    public abstract boolean isLogin(Provider provider);

}
