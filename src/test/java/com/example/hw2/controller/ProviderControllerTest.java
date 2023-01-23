package com.example.hw2.controller;

import com.example.hw2.pojo.dto.ProviderDTO;
import com.example.hw2.pojo.dto.ProviderRequestDTO;
import com.example.hw2.pojo.entity.Provider;
import com.example.hw2.service.ProviderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProviderControllerTest {

    @InjectMocks
    private ProviderController controller;

    @Mock
    private ProviderService service;

    private Provider t;

    @BeforeEach
    void setUp() {
        t = new Provider(2, "f", "l", "m", "dob");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getById() {
        Mockito.when(service.getByID(1)).thenReturn(null);
        ResponseEntity<ProviderDTO> response = controller.getById(1);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
        assertNull(response.getBody());

        Mockito.when(service.getByID(1)).thenReturn(t);
        response = controller.getById(1);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), new ProviderDTO(t));
    }

    @Test
    void insert() {
        Mockito.when(service.insert(t)).thenReturn(t);
        ResponseEntity<String> response = controller.insert(new ProviderRequestDTO(t));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), "Insert new provider");

        Provider fail = new Provider();
        fail.setDob("aa");
        response = controller.insert(new ProviderRequestDTO(fail));
        assertEquals(response.getStatusCode(), HttpStatus.NOT_ACCEPTABLE);
        assertEquals(response.getBody(), "Illegal provider");

    }
}