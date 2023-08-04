package com.mengedegan.Mengedegna.repositories;
import com.mengedegan.Mengedegna.entities.BusImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusImageRepository extends JpaRepository<BusImage,Long> {
    @Query(value = "SELECT * FROM bus_images as images WHERE images.image_url = :image_url", nativeQuery = true)
    BusImage findByBusImageUrl(String image_url);
}
