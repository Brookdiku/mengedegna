package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBusService {
    public MengedegnaApiResponse<Bus> createBus(Bus bus);
    public List<Bus> getBuses();
    public MengedegnaApiResponse<Bus> getBus(Long id);
    public MengedegnaApiResponse<Bus> updateBus(Bus bus, Long id);
    public MengedegnaApiResponse<Bus> deleteBus(Long id);
}
