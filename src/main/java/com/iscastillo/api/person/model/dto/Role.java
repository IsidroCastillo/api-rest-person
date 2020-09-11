package com.iscastillo.api.person.model.dto;

import com.iscastillo.api.person.enun.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrole")
    private long idRole;

    @Enumerated(EnumType.STRING)
    // @NotNull
    @Column(name = "rolename", unique = true)
    private RoleName roleName;

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

}
