package com.groupeisi.service;

import com.groupeisi.domain.Ief;
import com.groupeisi.exception.EntityNotFoundException;
import com.groupeisi.exception.RequestException;
import com.groupeisi.mapping.IefMapper;
import com.groupeisi.repository.IIefRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@AllArgsConstructor
@Service
public class IefService {

    IIefRepository iefRepository;
    IefMapper iefMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<Ief> getIefs(Pageable pageable) {
        return iefRepository.findAll(pageable).map(iefMapper::toIef);
    }

    @Transactional(readOnly = true)
    public Ief getIef(Long id) {
        return iefMapper.toIef(iefRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("ief.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Ief createIef(Ief ief) {
        iefRepository.findById(ief.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("ief.exists", new Object[]{ief.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return iefMapper.toIef(iefRepository.save(iefMapper.fromIef(ief)));
    }

    @Transactional
    public Ief updateIef(Long id, Ief ief){
        return iefRepository.findById(id)
                .map(entity -> {
                    ief.setId(id);
                    return iefMapper.toIef(iefRepository.save(iefMapper.fromIef(ief)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("ief.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteIef(Long id) {
        try {
            iefRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("ief.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
