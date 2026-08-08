package com.bkelly.demo.resource.controller;

import com.bkelly.demo.resource.api.ApiBApi;
import com.bkelly.demo.resource.model.ProtectedResourceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class ResourceControllerB implements ApiBApi {
    @Override
    public ResponseEntity<ProtectedResourceResponse> apiBV1Get() {
        ProtectedResourceResponse response = new ProtectedResourceResponse();
        response.setDate(OffsetDateTime.now());
        response.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        response.setMessage("This message is from the protected resource API B");
        return ResponseEntity.ok(response);
    }
}
