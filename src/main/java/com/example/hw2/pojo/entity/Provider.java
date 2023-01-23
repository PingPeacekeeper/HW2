package com.example.hw2.pojo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"ID", "first_name", "last_name"})
public class Provider {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column()
    @JsonProperty(value = "first_name")
    private String first_name;
    @Column()
    @JsonProperty(value = "last_name")
    private String last_name;
    @Column()
    @JsonProperty(value = "middle_name")
    private String middle_name;
    @Column()
    @JsonProperty(value = "dob")
    private String dob;

    public boolean checkLegal() {
        return last_name != null && first_name != null && dob != null &&
                last_name.length() != 0 && first_name.length() != 0 && dob.length() != 0;
    }

}
