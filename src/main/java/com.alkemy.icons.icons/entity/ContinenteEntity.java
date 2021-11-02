package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "continente")
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ContinenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    private boolean deleted = Boolean.FALSE;

}
