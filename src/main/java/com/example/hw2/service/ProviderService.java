package com.example.hw2.service;

import com.example.hw2.pojo.entity.Provider;
import org.springframework.stereotype.Service;

public interface ProviderService {
    Provider getByID(int id);

    Provider insert(Provider provider);
}
