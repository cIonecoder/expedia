package org.clonecoder.bookingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServerApplication.class, args);
    }

}
