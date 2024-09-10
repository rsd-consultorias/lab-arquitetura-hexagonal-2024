package br.com.rsdconsultoria.hexagonal.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile(value = { "prod", "uat", "dev" })
public class OAuthConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/docs/**").permitAll()
                .requestMatchers("/greetings/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated());
    
        return http.build();
    }
    
}
