package org.clonecoder.auth.config

import org.clonecoder.auth.common.redis.RedisClient
import org.redisson.spring.cache.RedissonSpringCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfig(
    private val redisClient: RedisClient
) {
//    @Bean
//    fun cacheManager(): RedissonSpringCacheManager {
//        return RedissonSpringCacheManager(redisClient.client, redisClient.configFile)
//    }
}