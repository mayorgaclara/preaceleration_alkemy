package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long habitantes;
    private Long superficie;
    private Long continenteId;
    private List<IconDTO> icons;

}
