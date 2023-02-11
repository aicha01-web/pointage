package com.groupeisi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ia implements Serializable {

    private Long Id;

    private String name;

    private Ief ief;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    private List<AppUser> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ief getIef() {
        return ief;
    }

    public void setIef(Ief ief) {
        this.ief = ief;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }


}
