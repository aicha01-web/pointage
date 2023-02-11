package com.groupeisi.controller;

import com.groupeisi.domain.Ia;
import com.groupeisi.entity.IaEntity;
import com.groupeisi.repository.IIaRepository;
import com.groupeisi.repository.IIefRepository;
import com.groupeisi.service.IaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/ias/")
public class IaController {

    IaService iaService;

    IIaRepository iaRepository;

    IIefRepository iefRepository;
    @GetMapping("/ias")
    public Page<Ia> getias(Pageable pageable) {
        return iaService.getIas(pageable);
    }

    @GetMapping("/ias/{id}")
    public ResponseEntity<Ia> getia(@PathVariable("id") Long id) {
        return ResponseEntity.ok(iaService.getIa(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Ia createia(@Valid @RequestBody Ia appia) {
        return iaService.createIa(appia);
    }

    @PutMapping("/ias/{id}")
    //@IsAdmin
    public Ia updateAppia(@PathVariable("id") Long id, @Valid @RequestBody Ia appia) {
        return iaService.updateIa(id, appia);
    }

    @DeleteMapping("/ias/{id}")
    public void deleteIa(@PathVariable("id") Long id) {
        iaService.deleteIa(id);
    }

//    public Ia addIefToIa(@PathVariable("id") Long iaId,@PathVariable("id") Long iefId){
//        Optional<IaEntity> ia = iaRepository.findById(iaId);
//        Roles roles = rolesdao.findById(idRole);
//        ingenieur.getRoles().add(roles);
//        return ingenieur;
//    }
}
