package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.model.PrestamoModel;
import java.util.Optional;

public interface PrestamoService {

    PrestamoModel createPrestamo(PrestamoModel prestamo);
    Optional<PrestamoModel> findPrestamoById(Long id);

}
