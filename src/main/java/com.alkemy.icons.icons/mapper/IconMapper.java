package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IconMapper {

    @Autowired
    private PaisMapper paisMapper;

    public IconEntity iconDTO2Entity(IconDTO dto, boolean loadPaises) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        if (loadPaises) {
            List<PaisEntity> paises = this.paisMapper.paisDTOList2EntityList(dto.getPaises());
            iconEntity.setPaises(paises);
        }
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        dto.setFechaCreacion(entity.getFechaCreacion());
        if (loadPaises) {
            List<PaisDTO> paisesDTO = this.paisMapper.paisEntityList2DTOList(entity.getPaises(), false);
            dto.setPaises(paisesDTO);
        }
        return dto;
    }

    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> entities, boolean loadPaises) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtos.add(this.iconEntity2DTO(entity, loadPaises));
        }
        return dtos;
    }

    public List<IconEntity> iconDTOList2EntityList(List<IconDTO> icons) {
        List<IconEntity> entities = new ArrayList<>();
        for (IconDTO dto : icons) {
            entities.add(iconDTO2Entity(dto, false));
        }
        return entities;
    }
}
