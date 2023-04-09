package com.pravnainfo.pravnainformatika.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sud;
    private String poslovniBroj;
    private String tuzilac;
    private String okrivljeni;
    private String krivicnoDelo;
    private Boolean osudjen;
    private String kaznaZatvor;
    private String kaznaNovac;
    private Boolean hladnoOruzije;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(
            name = "sudija_presuda",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "presuda_id"))
    private List<Korisnik> sudije;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(
            name = "telesna_povreda_presuda",
            joinColumns = @JoinColumn(name = "telesna_povreda_id"),
            inverseJoinColumns = @JoinColumn(name = "presuda_id"))
    private List<TelesnaPovreda> telesnePovrede;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(
            name = "propis_presuda",
            joinColumns = @JoinColumn(name = "propis_id"),
            inverseJoinColumns = @JoinColumn(name = "presuda_id"))
    private List<Propis> primenjeniPropisi;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(
            name = "krivicna_dela_presuda",
            joinColumns = @JoinColumn(name = "krivicno_delo_id"),
            inverseJoinColumns = @JoinColumn(name = "presuda_id"))
    private List<KrivicnoDelo> krivicnaDela;
}
