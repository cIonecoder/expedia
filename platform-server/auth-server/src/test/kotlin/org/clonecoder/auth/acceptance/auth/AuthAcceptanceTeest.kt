package org.clonecoder.auth.acceptance.auth

import org.clonecoder.auth.acceptance.AcceptanceTest
import org.clonecoder.member.support.DatabaseCleanup
import org.springframework.boot.web.server.LocalServerPort

internal class AuthAcceptanceTeest(
    databaseCleanup: DatabaseCleanup,
    @LocalServerPort private val port: Int
): AcceptanceTest(databaseCleanup, port) {
}