package org.scaler.ecommereceproductservice;

import org.scaler.ecommereceproductservice.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceProductServiceApplication implements CommandLineRunner {

    private final InitService initService;
    @Autowired
    public EcommerceProductServiceApplication(InitService initService) {
        this.initService = initService;
    }
    public static void main(String[] args) {
        SpringApplication.run(EcommerceProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initService.initData();
    }
}
