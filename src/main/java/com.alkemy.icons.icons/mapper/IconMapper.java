package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IconMapper {

    public IconEntity iconDTO2Entity(IconDTO dto) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        dto.setFechaCreacion(entity.getFechaCreacion());
        return dto;
    }

    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> entities) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtos.add(this.iconEntity2DTO(entity));
        }
        return dtos;
    }
}
