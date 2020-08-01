package com.ascencio.config;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientConfig {
        private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static HttpClient getHttpClient() {
        return httpClient;
    }
}