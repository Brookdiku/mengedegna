package com.mengedegan.Mengedegna.repositories;

import com.mengedegan.Mengedegna.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusRepository extends JpaRepository<Bus,Long> {
    @Query(value = "SELECT * FROM buses as buses WHERE buses.plate_number = :plateNumber", nativeQuery = true)
    Bus  findByPlateNumber(String plateNumber);
}
