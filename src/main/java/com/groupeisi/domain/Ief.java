package com.groupeisi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ief implements Serializable {

    private Long id;

    private String name;

    private List<Ia> ia;

    public List<Ia> getIa() {
        return ia;
    }

    public void setIa(List<Ia> ia) {
        this.ia = ia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
