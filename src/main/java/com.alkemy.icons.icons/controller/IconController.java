package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")

public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<List<IconDTO>> getAll(
            @RequestParam(value= "name", required = false) String iconName,
            @RequestParam(value= "date", required = false) String iconDate) {

        if (iconName != null) {
            return ResponseEntity.ok().body(iconService.getIconsByName(iconName));
        }
        if (iconDate != null) {
            return ResponseEntity.ok().body(iconService.getIconsByName(iconDate));
        }
        List<IconDTO> icons = iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO iconGuardado = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(iconGuardado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
