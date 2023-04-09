package com.pravnainfo.pravnainformatika.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sudija {
    @Id
    private Integer id;
    private String ime;
    private String prezime;
}
