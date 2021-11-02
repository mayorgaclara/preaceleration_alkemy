package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;


    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setDenominacion(dto.getDenominacion());
        paisEntity.setSuperficie(dto.getSuperficie());
        paisEntity.setContinenteId(dto.getContinenteId());
        paisEntity.setCantidadHabitantes(dto.getHabitantes());
        Set <IconEntity> icons = this.iconMapper.iconDTOList2EntityList(dto.getIcons());
        paisEntity.setIcons((List<IconEntity>) icons);
        return paisEntity;
    }

    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        dto.setContinenteId(entity.getContinenteId());
        if (loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntityList2DTOList((List<IconEntity>)entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }

        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }


    public Set<PaisEntity> paisDTOList2EntityList(List<PaisDTO> paises) {
        List<PaisEntity> entities = new ArrayList<>();
        for (PaisDTO dto : paises) {
            entities.add(paisDTO2Entity(dto));
        }
        return (Set<PaisEntity>) entities;
    }


}
