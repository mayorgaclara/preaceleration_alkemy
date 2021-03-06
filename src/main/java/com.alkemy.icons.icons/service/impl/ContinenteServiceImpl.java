package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;


    public ContinenteDTO save(ContinenteDTO dto) {
        // Operacion de guardado en 3 pasos:
        // Lo convierto a Entity
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        //Lo guardo y me devuelve la entidad guardada
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        //Convierto la entidad guardada en un dto
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;
    }

    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }

    public void delete(Long id) {
        this.continenteRepository.deleteById(id);
    }

}
