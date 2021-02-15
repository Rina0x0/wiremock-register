package com.project.WireMockRegister

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.*

public class MockLogic: FileReader {
    fun setUpWireMock() {
        configureFor(
            Configuration.config[Configuration.Wiremock.host],
            Configuration.config[Configuration.Wiremock.port]
        )
        WireMock.reset()
        setupApiMock()
    }

    fun setupApiMock() {
        stubFor(get(urlEqualTo("/v1/salesmans"))
            .willReturn(okJson(read("/response/expect.json"))))
    }
}
