package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;


    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved);
        return result;
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntityList2DTOList(entities);
        return result;
    }

    public List<IconDTO> getIconsByName(String name) {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconEntity> entitiesByName = new ArrayList<>();
        for(IconEntity icon: entities ) {
            if (icon.getDenominacion().equals(name)){
                entitiesByName.add(icon);
            }
        }
        return iconMapper.iconEntityList2DTOList(entitiesByName);
    }

    public List<IconDTO> getIconsByDate(LocalDate date) {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconEntity> entitiesByDate = new ArrayList<>();
        for(IconEntity icon: entities ) {
            if (icon.getFechaCreacion().equals(date)){
                entitiesByDate.add(icon);
            }
        }
        return iconMapper.iconEntityList2DTOList(entitiesByDate);
    }

    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

}
