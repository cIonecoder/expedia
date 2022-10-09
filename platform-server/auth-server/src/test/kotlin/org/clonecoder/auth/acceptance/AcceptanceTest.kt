package org.clonecoder.auth.acceptance

import io.kotest.core.spec.style.FeatureSpec
import org.clonecoder.member.support.DatabaseCleanup
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@ActiveProfiles("test")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest(
    private val databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): FeatureSpec()