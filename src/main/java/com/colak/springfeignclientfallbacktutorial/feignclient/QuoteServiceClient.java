package com.colak.springfeignclientfallbacktutorial.feignclient;

import com.colak.springfeignclientfallbacktutorial.externalservice.QuoteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;


@FeignClient(name = "quoteServiceClient", url = "https://this-is-a-placeholder.com")
public interface QuoteServiceClient {

    @GetMapping(path = "/getQuote/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CircuitBreaker(name = "quoteServiceClientCircuitBreaker", fallbackMethod = "quoteServiceClientFallbackMethod")
    ResponseEntity<QuoteResponse> getQuote(URI baseUrl, @PathVariable("id") int id);

    default ResponseEntity<QuoteResponse> quoteServiceClientFallbackMethod(URI baseUrl, int id, Throwable exception) {
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setMsg("default quote");
        return ResponseEntity.ok(quoteResponse);
    }

}
