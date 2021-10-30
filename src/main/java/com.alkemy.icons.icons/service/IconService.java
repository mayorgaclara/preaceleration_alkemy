package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.IconDTO;

import java.time.LocalDate;
import java.util.List;

public interface IconService {

    IconDTO save(IconDTO dto);

    List<IconDTO> getAllIcons();

    IconDTO getById(Long id);

    List<IconDTO> getIconsByName(String name);

    List<IconDTO> getIconsByDate(LocalDate date);

    void delete(Long id);
}
