package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;


    public PaisDTO save(PaisDTO dto) {
        PaisEntity entity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved);
        return result;
    }

    public List<PaisDTO> getAllPaises() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities);
        return result;
    }

}
