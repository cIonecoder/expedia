package com.expedia.b2b.documentation;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension.class) // 스니펫 생성을 위한 선언
@AutoConfigureRestDocs
public class Documentation {
    @LocalServerPort
    int port;

    protected RequestSpecification spec;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }
}
