package org.clonecoder.bookingserver.documentation.accommodation;

import io.restassured.RestAssured;
import org.clonecoder.bookingserver.documentation.Documentation;
import org.junit.jupiter.api.Test;

public class BookingDocumentationTestFilter extends Documentation {
    @Test
    public void 예약_생성_요청() {
        RestAssured
                .given(this.spec)
                    .log().all()
                    .filter(BookingDocumentationTest.예약_생성_요청());
    }
}
