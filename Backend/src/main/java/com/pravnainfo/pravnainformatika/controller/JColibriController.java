package com.pravnainfo.pravnainformatika.controller;

import com.pravnainfo.pravnainformatika.jcolibri.JColibriApp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/jcolibri")
@RestController
public class JColibriController {

    @GetMapping("getColibri")
    public ResponseEntity<String> getColibri(){
        JColibriApp.jcolibri();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
