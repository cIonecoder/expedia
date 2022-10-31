package org.clonecoder.member.documentation

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource


@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension::class)
internal class Documentation {

    @LocalServerPort
    lateinit var port: String

    protected lateinit var spec: RequestSpecification

    @BeforeEach
    fun setUp(documentation: RestDocumentationContextProvider) {
        RestAssured.port = port.toInt()
        this.spec = RequestSpecBuilder()
            .addFilter(documentationConfiguration(documentation)
                    .operationPreprocessors()
                    .withRequestDefaults(prettyPrint())
                    .withResponseDefaults(prettyPrint()))
            .build()
    }
}