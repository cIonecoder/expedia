package org.clonecoder.bookingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"org.clonecoder.bookingserver", "org.clonecoder.productserver"})
public class BookingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServerApplication.class, args);
    }

}
