package org.clonecoder.member.config

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.clonecoder.member.common.properties.AdapterProperties
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.codec.LoggingCodecSupport
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit
import java.util.function.BiConsumer
import java.util.function.Consumer

@Configuration
class AuthWebClientConfig(
    private val adapterProperties: AdapterProperties
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun weatherWebClient(): WebClient {
        val exchangeStrategies = ExchangeStrategies.builder()
            .codecs { configurer: ClientCodecConfigurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 50) }
            .build()
        exchangeStrategies
            .messageReaders().stream()
            .filter(LoggingCodecSupport::class.java::isInstance)
            .forEach {
                writer -> apply {
                    val logger = writer as LoggingCodecSupport
                    logger.isEnableLoggingRequestDetails = true
                }
            }

        val httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .responseTimeout(Duration.ofMillis(5000))
            .doOnConnected { conn ->
                conn.apply {
                    conn.addHandlerLast(ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                        .addHandlerLast(WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                }
            }

        return WebClient.builder()
            .baseUrl(adapterProperties.authServer.getUrl())
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .exchangeStrategies(exchangeStrategies)
            .filter(ExchangeFilterFunction.ofRequestProcessor {
                log.debug("Request: {} {}", it.method(), it.url())
                it.headers().forEach(BiConsumer { name: String?, values: List<String?> -> values.forEach(Consumer { value: String? -> log.debug("{} : {}", name, value) }) })
                Mono.just(it)
            })
            .filter(ExchangeFilterFunction.ofResponseProcessor {
                it.headers().asHttpHeaders().forEach(BiConsumer { name: String?, values: List<String?> -> values.forEach(Consumer { value: String? -> log.debug("{} : {}", name, value) }) })
                Mono.just(it)
            })
            .build()
    }
}