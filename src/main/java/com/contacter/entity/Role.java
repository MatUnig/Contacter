package com.contacter.entity;

import javax.persistence.*;

/**
 * Role dostępu dla użytkowników.
 * Aktualnie zawiera jedynie rolę USER - Do rozbudowy przy rozwoju aplikacji.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}