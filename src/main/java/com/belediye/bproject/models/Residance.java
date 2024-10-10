package com.belediye.bproject.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="residance")
public class Residance {
    @Id
    @Column(name = "national_id_no")
    private Long nationalIdNo;
    @Column(name = "city")
    private  String city;
    @Column(name = "district")
    private  String district;
    @Column(name = "post_code")
    private  String postCode;
    @Column(name = "address")
    private  String address;

    public Long getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(Long nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
