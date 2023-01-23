package com.example.hw2.service.impl;

import com.example.hw2.pojo.entity.Provider;
import com.example.hw2.repository.ProviderRepository;
import com.example.hw2.service.ProviderService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProviderServiceImplTest {

    @Qualifier("providerServiceImpl")
    @Autowired
    private ProviderService service;

    @MockBean
    private ProviderRepository repo;

    private Provider t;

    @BeforeEach
    void setUp() {
        t = new Provider(2, "f", "l", "m", "dob");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getByID() {
        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());
        Provider p = service.getByID(1);
        assertNull(p);

        Mockito.when(repo.findById(2)).thenReturn(Optional.of(t));
        assertEquals(t, service.getByID(2));
    }

    @Test
    void insert() {
        Mockito.when(repo.save(t)).thenReturn(t);
        assertEquals(repo.save(t), t);
    }
}