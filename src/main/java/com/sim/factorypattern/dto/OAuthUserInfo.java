package com.sim.factorypattern.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OAuthUserInfo {
    private final String username;
    private final String email;
}
