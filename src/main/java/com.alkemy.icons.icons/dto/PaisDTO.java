package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long habitantes;
    private Long superficie;
}
