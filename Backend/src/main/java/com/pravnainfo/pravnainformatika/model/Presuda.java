package com.pravnainfo.pravnainformatika.model;

import com.pravnainfo.pravnainformatika.model.enums.TipKazne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presuda {
    @Id
    private Integer id;
    private String sud;
    private String poslovniBroj;
    private String sudija;
    private String tuzilac;
    private String okrivljeni;
    private String krivicnoDelo;
    private String telesnePovrede;
    private Boolean osudjen;
    private String primenjeniPropisi;
    private Double kaznaZatvor;
    private Double kaznaNovac;
}
