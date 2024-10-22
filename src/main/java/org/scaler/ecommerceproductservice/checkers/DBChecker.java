package org.scaler.ecommerceproductservice.checkers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Component
public class DBChecker {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @PostConstruct
    public void printDataSourceConfig() {
        System.out.println("Datasource URL: " + dataSourceUrl);
        System.out.println("Datasource Username: " + dataSourceUsername);
        // Avoid printing passwords in production!
        System.out.println("Datasource Password: " + dataSourcePassword);
    }
}
