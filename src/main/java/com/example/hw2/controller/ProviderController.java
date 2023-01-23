package com.example.hw2.controller;

import com.example.hw2.exception.CustomException;
import com.example.hw2.pojo.dto.ProviderDTO;
import com.example.hw2.pojo.dto.ProviderRequestDTO;
import com.example.hw2.pojo.entity.Provider;
import com.example.hw2.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo")
public class ProviderController {
    private final ProviderService service;

    @Autowired
    public ProviderController(ProviderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getById(@PathVariable int id) {
        Provider p = service.getByID(id);
        if (p == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ProviderDTO(p), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> insert(@RequestBody ProviderRequestDTO requestDTO) {
        Provider provider = requestDTO.getProvider();
        System.out.println(provider);
        if (!provider.checkLegal()) return new ResponseEntity<>("Illegal provider", HttpStatus.NOT_ACCEPTABLE);
        service.insert(provider);
        return new ResponseEntity<>("Insert new provider", HttpStatus.OK);
    }

    @GetMapping("/customException")
    public ResponseEntity<ProviderDTO> testCustomException() {
        throw new CustomException(1, "test Custom Exception");
    }

    @GetMapping("/runtimeException")
    public ResponseEntity<ProviderDTO> testRuntimeException() {
        throw new RuntimeException("test Runtime Exception");
    }
}
