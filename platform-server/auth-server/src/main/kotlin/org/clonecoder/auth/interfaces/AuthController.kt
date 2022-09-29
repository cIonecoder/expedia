package org.clonecoder.auth.interfaces

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController {

    // 일단 토큰 생성 endpoint 는 member-server 에서만 요청을 받도록 하자
    @PostMapping("/token")
    fun createToken() {
        // TODO implementations
    }
}