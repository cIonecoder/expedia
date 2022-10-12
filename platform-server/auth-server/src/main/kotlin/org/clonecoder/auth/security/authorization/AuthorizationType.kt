package org.clonecoder.auth.security.authorization


enum class AuthorizationType {
    BASIC, BEARER,
    ;

    fun toLowerCase() = this.name.lowercase()
}