package com.groupeisi.service;

import com.groupeisi.domain.Ia;
import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;
import com.groupeisi.mapping.IaMapper;
import com.groupeisi.repository.IIaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@AllArgsConstructor
public class IaService {

    IIaRepository iaRepository;
    IaMapper iaMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<Ia> getIas(Pageable pageable) {
        return iaRepository.findAll(pageable).map(iaMapper::toIa);
    }

    @Transactional(readOnly = true)
    public Ia getIa(Long id) {
        return iaMapper.toIa(iaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("ia.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Ia createIa(Ia ia) {
        iaRepository.findById(ia.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("ia.exists", new Object[]{ia.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return iaMapper.toIa(iaRepository.save(iaMapper.fromIa(ia)));
    }

    @Transactional
    public Ia updateIa(Long id, Ia ia){
        return iaRepository.findById(id)
                .map(entity -> {
                    ia.setId(id);
                    return iaMapper.toIa(iaRepository.save(iaMapper.fromIa(ia)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("ia.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteIa(Long id) {
        try {
            iaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("ia.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
