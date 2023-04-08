package com.pravnainfo.pravnainformatika.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Korisnik {

	@Id
    private Integer idKorisnika;
	private String ime;
	private String prezime;
	private String jmbg;
	
	private String korisnickoIme;
	private String lozinka;
	
}
