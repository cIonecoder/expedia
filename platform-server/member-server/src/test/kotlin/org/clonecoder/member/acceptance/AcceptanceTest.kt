package org.clonecoder.member.acceptance

import io.kotest.core.spec.style.FeatureSpec
import io.restassured.RestAssured
//import org.clonecoder.core.config.DataSourceConfig
import org.clonecoder.member.support.DatabaseCleanup
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.test.context.TestPropertySource

//@Import(value = [DataSourceConfig::class])
@TestPropertySource(properties = ["spring.config.location=classpath:application-test.yml"])
@TestConstructor(autowireMode = ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest(
    private val databaseCleanup: DatabaseCleanup,
    @LocalServerPort port: Int,
): FeatureSpec() {
    init {
        RestAssured.port = port
//        databaseCleanup.execute()
    }
}