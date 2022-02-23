package com.devms.hrapigatewaycloud.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

    @Bean //
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("MY-SECRET-KEY");
        return tokenConverter;
    }

    @Bean //responsavel por ler as informacoes do token
    public JwtTokenStore tokenStore (){
        return new JwtTokenStore(accessTokenConverter());
    }
}
