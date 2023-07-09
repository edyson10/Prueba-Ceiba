package com.ceiba.biblioteca.controller;

import com.ceiba.biblioteca.model.PrestamoModel;
import com.ceiba.biblioteca.services.impl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    PrestamoServiceImpl prestamoService;

    @PostMapping
    public PrestamoModel create(@RequestBody PrestamoModel prestamo){
        return prestamoService.createPrestamo(prestamo);
    }

    @GetMapping(path = "/{id-prestamo}")
    public Optional<PrestamoModel> findPrestamoById(@PathVariable("id-prestamo") long id){
        return prestamoService.findPrestamoById(id);
    }
}

