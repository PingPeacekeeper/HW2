package com.example.hw2.pojo.dto;

import com.example.hw2.pojo.entity.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProviderRequestDTO {
    private Provider provider;
}
