package com.sim.factorypattern.observer.subject;

import com.sim.factorypattern.dto.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OAuth implements Status {
    private Provider provider;
    private String accessToken;
}
