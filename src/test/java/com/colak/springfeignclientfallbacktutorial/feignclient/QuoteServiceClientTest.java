package com.colak.springfeignclientfallbacktutorial.feignclient;

import com.colak.springfeignclientfallbacktutorial.externalservice.QuoteResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
class QuoteServiceClientTest {

    @Autowired
    private QuoteServiceClient quoteServiceClient;

    // curl -k -i --http2 https://localhost:8080/api/service/getQuote/1
    // -k accepts self-signed certificate
    // -i shows headers
    // --http2 uses htt2
    @Test
    void testFallback() {
        URI baseUrl = URI.create("https://localhost:8080/api/service");
        ResponseEntity<QuoteResponse> responseEntity = quoteServiceClient.getQuote(baseUrl, 2);
        QuoteResponse quoteResponse = responseEntity.getBody();
        Assertions.assertEquals("default quote", quoteResponse.getMsg());
    }

}
