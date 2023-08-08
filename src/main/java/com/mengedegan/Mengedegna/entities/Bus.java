package com.mengedegan.Mengedegna.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plate number is required")
    @Column(name = "plate_number", length = 20,unique = true)
    private String plateNumber;

    @Column(name = "total_seats")
    private int totalSeats;

    @NotBlank(message = "Grade is required.")
    @Column(length = 10)
    private String grade;
    @OneToMany(mappedBy = "bus")
    @JsonManagedReference
    private List<BusImage> images;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private Long createdBy;
}
