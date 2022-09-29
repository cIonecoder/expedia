package org.clonecoder.member.acceptance

import org.clonecoder.member.support.DatabaseCleanup
import io.kotest.core.spec.style.FeatureSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@ActiveProfiles("test")
@TestConstructor(autowireMode = ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcceptanceTest(
    private val databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): FeatureSpec()