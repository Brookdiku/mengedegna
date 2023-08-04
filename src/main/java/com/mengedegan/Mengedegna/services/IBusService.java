package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;

import java.util.List;

public interface IBusService {
    MengedegnaApiResponse<Bus> createBus(Bus bus);

    List<Bus> getBuses();

    MengedegnaApiResponse<Bus> getBus(Long id);

    MengedegnaApiResponse<Bus> updateBus(Bus bus, Long id);

    MengedegnaApiResponse<Bus> deleteBus(Long id);
}
