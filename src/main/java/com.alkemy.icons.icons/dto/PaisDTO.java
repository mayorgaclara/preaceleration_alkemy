package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long habitantes;
    private Long superficie;
    private Set<IconEntity> icons;
    private Long continenteId;
}
