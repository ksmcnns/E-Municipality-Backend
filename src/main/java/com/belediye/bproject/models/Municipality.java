package com.belediye.bproject.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="municipality")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipality_id")
    private int municipalityId;
    @Column(name = "municipality_name")
    private String municipalityName;
    @Column(name = "municipality_address")
    private String municipalityAdress;
    @Column(name = "city_of_municipality")
    private  String cityOfMunicipality;

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getMunicipalityAdress() {
        return municipalityAdress;
    }

    public void setMunicipalityAdress(String municipalityAdress) {
        this.municipalityAdress = municipalityAdress;
    }

    public String getCityOfMunicipality() {
        return cityOfMunicipality;
    }

    public void setCityOfMunicipality(String cityOfMunicipality) {
        this.cityOfMunicipality = cityOfMunicipality;
    }
}
