package com.devms.hroauth.AppConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean //responsavel por encripitar
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean //
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecret);
        return tokenConverter;
    }

    @Bean //responsavel por ler as informacoes do token
    public JwtTokenStore tokenStore (){
        return new JwtTokenStore(accessTokenConverter());
    }
}
