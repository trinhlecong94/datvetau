package com.mycompany.datvetau.entities;

import com.mycompany.datvetau.entities.enums.Role;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrators_role")
public class AdministratorsRoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Role roles = Role.ROLE_SELLER;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String getRoleString() {
        return roles.toString();
    }
}
