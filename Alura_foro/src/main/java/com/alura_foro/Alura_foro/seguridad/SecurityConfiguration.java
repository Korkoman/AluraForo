package com.alura_foro.Alura_foro.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    private static SecurityFilter  securityFilter = null;

    public SecurityConfiguration(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Configuration
    @EnableWebSecurity
    public static class SecurityConfigurations {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity.csrf(csrf -> csrf.disable())
                    .sessionManagement( sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeRequests((auth) -> auth
                            .requestMatchers(HttpMethod.POST, "/login")
                            .permitAll()
                            .requestMatchers(HttpMethod.POST,"/usuario")
                            .permitAll()
                            .requestMatchers(HttpMethod.DELETE,"/usuario")
                            .permitAll()
                            .requestMatchers("/swagger-ui.html","/v3/api-docs/**","/swagger-ui/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated()
                            .and()
                            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                    ).build();
        }
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}