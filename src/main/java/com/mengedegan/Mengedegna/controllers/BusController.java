package com.mengedegan.Mengedegna.controllers;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.services.IBusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    IBusService busService;

    @PostMapping("/buses")
    public ResponseEntity<?> createBus(@Valid @RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busService.getBuses();
    }

    @GetMapping("/buses/{id}")
    public Bus getBuses(@Param("id") Long id) {
        return busService.getBus(id);
    }

    @PutMapping("/buses/{id}")
    public Bus updateBus(@Valid  @RequestBody Bus bus, @Param("id") Long id) {
        return busService.updateBus(bus, id);
    }

    @DeleteMapping("/buses/{id}")
    public String deleteBus(@Param("id") Long id) {
        return busService.deleteBus(id);
    }
}
