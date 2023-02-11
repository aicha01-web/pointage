package com.groupeisi.controller;

import com.groupeisi.domain.Ief;
import com.groupeisi.service.IefService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class IefController {

    IefService iefService;

    @GetMapping("/iefs")
    public Page<Ief> getIefs(Pageable pageable) {
        return iefService.getIefs(pageable);
    }

    @GetMapping("/iefs/{id}")
    public ResponseEntity<Ief> getief(@PathVariable("id") Long id) {
        return ResponseEntity.ok(iefService.getIef(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Ief createief(@Valid @RequestBody Ief appief) {
        return iefService.createIef(appief);
    }

    @PutMapping("/iefs/{id}")
    //@IsAdmin
    public Ief updateAppief(@PathVariable("id") Long id, @Valid @RequestBody Ief appief) {
        return iefService.updateIef(id, appief);
    }

    @DeleteMapping("/iefs/{id}")
    public void deleteIef(@PathVariable("id") Long id) {
        iefService.deleteIef(id);
    }
}
