package org.scaler.ecommerceproductservice.security.configuration;

import org.scaler.ecommerceproductservice.commons.AuthenticationCommons;
import org.scaler.ecommerceproductservice.security.ProductServiceAuthenticationFilter;
import org.scaler.ecommerceproductservice.security.handlers.ProductServiceAuthenticationEntryPoint;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Configuration
@EnableWebSecurity
public class ProductServiceSecurityConfiguration {

    private final AuthenticationCommons authenticationCommons;
    private final ProductServiceAuthenticationEntryPoint productServiceAuthenticationEntryPoint;
    //constructor
    public ProductServiceSecurityConfiguration(
            AuthenticationCommons authenticationCommons,
            ProductServiceAuthenticationEntryPoint productServiceAuthenticationEntryPoint
    ) {
        this.authenticationCommons = authenticationCommons;
        this.productServiceAuthenticationEntryPoint = productServiceAuthenticationEntryPoint;
    }

    @Bean
    public FilterRegistrationBean<ProductServiceAuthenticationFilter> registration(ProductServiceAuthenticationFilter filter) {
        FilterRegistrationBean<ProductServiceAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public ProductServiceAuthenticationFilter getProductServiceAuthenticationFilter(){
        return new ProductServiceAuthenticationFilter(authenticationCommons);
    }

    @Bean
    public SecurityFilterChain productServiceFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/product/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(productServiceAuthenticationEntryPoint)
                )
                .addFilterBefore(getProductServiceAuthenticationFilter(), AuthorizationFilter.class)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .build();
    }
}
