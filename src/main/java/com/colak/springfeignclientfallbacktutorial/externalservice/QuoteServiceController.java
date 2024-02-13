package com.colak.springfeignclientfallbacktutorial.externalservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/service")
public class QuoteServiceController {

    // http://localhost:8080/api/service/getQuote/2

    /**
     * This controller may throw exception
     */
    @GetMapping(path = "getQuote/{id}")
    public ResponseEntity<QuoteResponse> getQuote(@PathVariable("id") int id) {
        if (id == 2) {
            return ResponseEntity.badRequest().build();
        } else if (id == 3) {
            return ResponseEntity.internalServerError().build();
        }

        String message = "Quote 1 : " + id;
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setMsg(message);
        return ResponseEntity.ok(quoteResponse);
    }
}
