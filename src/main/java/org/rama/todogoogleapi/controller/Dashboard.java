package org.rama.todogoogleapi.controller;

import org.rama.todogoogleapi.dto.GoogleApiDto;
import org.rama.todogoogleapi.dto.SpreadsheetLite;
import org.rama.todogoogleapi.service.GoogleApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class Dashboard {
   @Autowired
   private GoogleApiService googleApiService;

    @PostMapping("/create")
    public SpreadsheetLite createSheet(@RequestBody GoogleApiDto request) throws IOException, GeneralSecurityException {
        return googleApiService.createSheet(request);
    }

}
