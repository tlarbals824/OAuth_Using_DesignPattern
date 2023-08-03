package com.sim.factorypattern.observer.subject;

import com.sim.factorypattern.dto.OAuthRequest;
import com.sim.factorypattern.dto.OAuthResponse;
import com.sim.factorypattern.dto.OAuthUserInfo;
import com.sim.factorypattern.observer.observer.AbstractOAuthObserver;
import com.sim.factorypattern.observer.observer.Observer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public final class AbstractOAuthSubject implements Subject<OAuthRequest, OAuthResponse> {
    private final List<AbstractOAuthObserver> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer<? extends Status,?> o) {
        observerList.add((AbstractOAuthObserver) o);
    }

    @Override
    public void removeObserver(Observer<? extends Status, ?> o) {
        observerList.remove((AbstractOAuthObserver) o);
    }

    @Override
    public OAuthResponse notifyObservers(OAuthRequest object) {
        final OAuthUserInfo oAuthUserInfo = attemptLogin(new OAuth(object.getProvider(), object.getAccessToken()));
        return generateServerAccessTool(oAuthUserInfo);
    }

    private OAuthUserInfo attemptLogin(OAuth oAuth) {
        for (AbstractOAuthObserver abstractOAuthObserver : observerList) {
            if (abstractOAuthObserver.isLogin(oAuth.getProvider())) {
                return abstractOAuthObserver.accept(oAuth);
            }
        }
        throw new IllegalArgumentException("로그인 실패");
    }

    private OAuthResponse generateServerAccessTool(OAuthUserInfo oAuthUserInfo) {
        return new OAuthResponse(oAuthUserInfo.getEmail()+" "+oAuthUserInfo.getUsername());
    }

//    public void initObserver(ApplicationContext applicationContext){
//        applicationContext.getBeansOfType(AbstractOAuthObserver.class)
//                .values()
//                .forEach(this::registerObserver);
//    }
}
