package org.clonecoder.auth.common.security.authorization


enum class AuthorizationType {
    BASIC, BEARER,
    ;

    fun toLowerCase() = this.name.lowercase()
}