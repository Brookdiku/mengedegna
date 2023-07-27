package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.repositories.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BusService implements IBusService{
    @Autowired
    IBusRepository busRepository;
    @Override
    public ResponseEntity<?> createBus(Bus bus) {
        try {
            Bus existingBus = busRepository.findByPlateNumber(bus.getPlateNumber());
            if (existingBus != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Plate number already in use.");
            }
            Bus createdBus = busRepository.save(bus);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create bus.");
        }
    }
    @Override
    public List<Bus> getBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBus(Long id) {
        return busRepository.findById(id).get();
    }

    @Override
    public Bus updateBus(Bus bus,Long id) {
        return null;
    }

    @Override
    public String deleteBus(Long id) {
        busRepository.deleteById(id);
        return "successfully deleted.";
    }
}