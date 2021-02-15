package com.project.WireMockRegister

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.fromResource

class Configuration {
    companion object {
        val config = EnvironmentVariables overriding fromResource("application.properties")
    }

    object Wiremock: PropertyGroup() {
        val host by stringType
        val port by intType
    }
}