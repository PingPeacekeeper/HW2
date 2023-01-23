package com.example.hw2.pojo.dto;

import com.example.hw2.pojo.entity.Provider;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProviderDTO {
    private String first_name;
    private String last_name;
    private String middle_name;
    private String dob;

    public ProviderDTO(Provider p) {
        this.first_name = p.getFirst_name();
        this.last_name = p.getLast_name();
        this.middle_name = p.getMiddle_name();
        this.dob = p.getDob();
    }
}
