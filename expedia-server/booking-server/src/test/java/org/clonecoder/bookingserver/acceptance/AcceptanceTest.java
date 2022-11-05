package org.clonecoder.bookingserver.acceptance;

import io.restassured.RestAssured;
import org.clonecoder.bookingserver.BookingTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

public class AcceptanceTest extends BookingTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }
}
