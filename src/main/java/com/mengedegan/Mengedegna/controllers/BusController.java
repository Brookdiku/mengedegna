package com.mengedegan.Mengedegna.controllers;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.services.IBusService;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    IBusService busService;

    @PostMapping("/buses")
    public MengedegnaApiResponse<Bus> createBus(@Valid @RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busService.getBuses();
    }

    @GetMapping("/buses/{id}")
    public MengedegnaApiResponse<Bus> getBus(@PathVariable("id") Long id) {
        return busService.getBus(id);
    }

    @PutMapping("/buses/{id}")
    public MengedegnaApiResponse<Bus> updateBus(@Valid  @RequestBody Bus bus, @PathVariable("id") Long id) {
        return busService.updateBus(bus, id);
    }

    @DeleteMapping("/buses/{id}")
    public MengedegnaApiResponse<Bus> deleteBus(@PathVariable("id") Long id) {
        return busService.deleteBus(id);
    }
}
