package org.clonecoder.auth.common.exception

class RedisClientException(
    override val message: String = "RedisClient Error"
): RuntimeException(message) {
}