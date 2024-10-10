package com.belediye.bproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAuthenticationDTO {
    private Long nationalIdNo;
    private String password;
    private String name;
    private String surname;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(Long nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
