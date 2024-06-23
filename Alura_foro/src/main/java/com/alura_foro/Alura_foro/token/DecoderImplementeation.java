package com.alura_foro.Alura_foro.token;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
public class DecoderImplementeation {

    @Bean
    public DecodedJWT decode() {
        return new DecodedJWT() {
            @Override
            public String getToken() {
                return "";
            }

            @Override
            public String getHeader() {
                return "";
            }

            @Override
            public String getPayload() {
                return "";
            }

            @Override
            public String getSignature() {
                return "";
            }

            @Override
            public String getAlgorithm() {
                return "";
            }

            @Override
            public String getType() {
                return "";
            }

            @Override
            public String getContentType() {
                return "";
            }

            @Override
            public String getKeyId() {
                return "";
            }

            @Override
            public Claim getHeaderClaim(String s) {
                return null;
            }

            @Override
            public String getIssuer() {
                return "";
            }

            @Override
            public String getSubject() {
                return "";
            }

            @Override
            public List<String> getAudience() {
                return List.of();
            }

            @Override
            public Date getExpiresAt() {
                return null;
            }

            @Override
            public Date getNotBefore() {
                return null;
            }

            @Override
            public Date getIssuedAt() {
                return null;
            }

            @Override
            public String getId() {
                return "";
            }

            @Override
            public Claim getClaim(String s) {
                return null;
            }

            @Override
            public Map<String, Claim> getClaims() {
                return Map.of();
            }
        };
    }


}
