package com.Beaver.MainService.domain.service.social;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.websocket.server.ServerEndpoint;
import java.util.Properties;

@Getter
@Setter
@ToString
public class GoogleProfile {
    private Long id;
    private Properties properties;

    @Getter
    @Setter
    @ToString
    private static class Properties {
        private String nickname;
        private String profile;
    }
}
