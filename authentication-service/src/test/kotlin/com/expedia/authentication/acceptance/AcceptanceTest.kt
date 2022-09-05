package com.expedia.authentication.acceptance

import com.expedia.authentication.support.DatabaseCleanup
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest {

    @Autowired lateinit var databaseCleanup: DatabaseCleanup

    @LocalServerPort
    lateinit var port: String

    @BeforeEach
    fun setUp() {
        RestAssured.port = port.toInt()
        databaseCleanup.execute()
    }
}