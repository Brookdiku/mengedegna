package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.Bus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBusService {
    public ResponseEntity<?> createBus(Bus bus);
    public List<Bus> getBuses();
    public Bus getBus(Long id);
    public Bus updateBus(Bus bus, Long id);
    public String deleteBus(Long id);
}
