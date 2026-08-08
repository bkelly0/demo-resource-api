package com.bkelly.demo.resource.controller;

import com.bkelly.demo.resource.api.ApiAApi;
import com.bkelly.demo.resource.model.ProtectedResourceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class ResourceControllerA implements ApiAApi {
    @Override
    public ResponseEntity<ProtectedResourceResponse> apiAV1Get() {
        ProtectedResourceResponse response = new ProtectedResourceResponse();
        response.setDate(OffsetDateTime.now());
        response.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        response.setMessage("This message is from the protected resource API A");
        return ResponseEntity.ok(response);
    }
}
