package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IconDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private LocalDate fechaCreacion;
    private Long altura;
    private String historia;
}
