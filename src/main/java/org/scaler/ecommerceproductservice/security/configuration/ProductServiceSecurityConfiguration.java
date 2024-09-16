package org.scaler.ecommerceproductservice.security.configuration;

import org.scaler.ecommerceproductservice.commons.AuthenticationCommons;
import org.scaler.ecommerceproductservice.security.ProductServiceAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Configuration
@EnableWebSecurity
public class ProductServiceSecurityConfiguration {

    private final AuthenticationCommons authenticationCommons;

    //constructor
    public ProductServiceSecurityConfiguration(AuthenticationCommons authenticationCommons) {
        this.authenticationCommons = authenticationCommons;
    }

    @Bean
    public ProductServiceAuthenticationFilter getProductServiceAuthenticationFilter(){
        return new ProductServiceAuthenticationFilter(authenticationCommons);
    }

    @Bean
    public SecurityFilterChain productServiceFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/product/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(getProductServiceAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
