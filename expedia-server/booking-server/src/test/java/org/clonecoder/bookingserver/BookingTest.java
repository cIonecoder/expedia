package org.clonecoder.bookingserver;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql({"classpath:accommodation/schema/accommodation.sql"
        , "classpath:accommodation/data/accommodation_1.sql"
        , "classpath:accommodation/data/accommodation_2.sql"
        , "classpath:accommodation/data/accommodation_3.sql"
        , "classpath:accommodation/data/accommodation_code.sql"}
)
public class BookingTest {
}
