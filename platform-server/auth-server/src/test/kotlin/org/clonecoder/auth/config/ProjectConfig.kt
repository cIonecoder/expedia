package org.clonecoder.auth.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.extensions.spring.SpringExtension

object ProjectConfig : AbstractProjectConfig() {
    override val parallelism = 8

    override val isolationMode = IsolationMode.InstancePerLeaf

    override fun extensions() = listOf(SpringExtension)
}