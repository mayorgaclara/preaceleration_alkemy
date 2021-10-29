package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {

    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setDenominacion(dto.getDenominacion());
        return paisEntity;
    }

    public PaisDTO paisEntity2DTO(PaisEntity entity) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(this.paisEntity2DTO(entity));
        }
        return dtos;
    }
}
