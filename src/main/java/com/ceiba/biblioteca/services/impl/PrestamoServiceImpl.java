package com.ceiba.biblioteca.services.impl;

import com.ceiba.biblioteca.exceptions.UserTypeNotAllowedException;
import com.ceiba.biblioteca.exceptions.ForbiddenException;
import com.ceiba.biblioteca.model.PrestamoModel;
import com.ceiba.biblioteca.repositories.PrestamoRepository;
import com.ceiba.biblioteca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Override
    public PrestamoModel createPrestamo(PrestamoModel prestamoModel) {

        String maximumReturnDate;
        List<PrestamoModel> prestamosByIdentificacionUsuario;

        if (prestamoModel.getTipoUsuario() > 3 || prestamoModel.getTipoUsuario() < 1) {
            throw new UserTypeNotAllowedException();
        }

        prestamosByIdentificacionUsuario = prestamoRepository.findByIdentificacionUsuario(prestamoModel.getIdentificacionUsuario());

        if (!prestamosByIdentificacionUsuario.isEmpty() && (prestamoModel.getTipoUsuario() == 3)) {
            throw new ForbiddenException(prestamoModel.getIdentificacionUsuario());
        }

        maximumReturnDate = calculateUserDates(prestamoModel.getTipoUsuario()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        prestamoModel.setFechaMaximaDevolucion(maximumReturnDate);

        return prestamoRepository.save(prestamoModel);
    }

    private LocalDate calculateUserDates(int userType) {
        LocalDate maximumDate = LocalDate.now();
        int permittedDays = 0;

        switch (userType) {
            case 1:
                permittedDays = 10;
                break;

            case 2:
                permittedDays = 8;
                break;

            case 3:
                permittedDays = 7;
                break;

            default:
                permittedDays = 0;
                break;

        }

        return validDays(maximumDate, permittedDays);
    }

    private LocalDate validDays(LocalDate today, int loanDays) {

        LocalDate maximumDate = today;
        int addDays = 0;

        if (loanDays < 1) {
            return today;
        }

        while (addDays < loanDays) {
            maximumDate = maximumDate.plusDays(1);
            if (!(maximumDate.getDayOfWeek() == DayOfWeek.SATURDAY || maximumDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addDays;
            }
        }
        return maximumDate;
    }

    @Override
    public Optional<PrestamoModel> findPrestamoById(Long id) {
        return prestamoRepository.findById(id);
    }

}
