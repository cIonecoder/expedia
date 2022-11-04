package org.clonecoder.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.clonecoder.coreserver"})
public class ProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }

}
