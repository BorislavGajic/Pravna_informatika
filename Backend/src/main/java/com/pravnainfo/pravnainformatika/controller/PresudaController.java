package com.pravnainfo.pravnainformatika.controller;

import com.pravnainfo.pravnainformatika.model.Presuda;
import com.pravnainfo.pravnainformatika.repositories.PresudaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/presuda")
@RestController
public class PresudaController {
    @Autowired
    private PresudaRepository presudaRepository;

    @GetMapping()
    public ResponseEntity<List<Presuda>> getPresude(){
        List<Presuda> presude = presudaRepository.findAll();
        return new ResponseEntity<>(presude,HttpStatus.OK);

    }
}
