package com.ceiba.biblioteca.repositories;

import com.ceiba.biblioteca.model.PrestamoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoModel, Long> {
    List<PrestamoModel> findByIdentificacionUsuario(String identificacionUsuario);
}
