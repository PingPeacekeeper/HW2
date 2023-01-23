package com.example.hw2.service.impl;

import com.example.hw2.pojo.entity.Provider;
import com.example.hw2.repository.ProviderRepository;
import com.example.hw2.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository repo) {
        this.repository = repo;
    }

    @Override
    public Provider getByID(int id) {
        Optional<Provider> p = repository.findById(id);
        return p.orElse(null);
    }

    @Override
    public Provider insert(Provider provider) {
        return repository.save(provider);
    }
}
