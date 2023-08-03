package com.mengedegan.Mengedegna.services;
import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.repositories.IBusRepository;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class BusService implements IBusService{
    @Autowired
    IBusRepository busRepository;
    @Override
    public MengedegnaApiResponse<Bus> createBus(Bus bus) {
        String message;
        try {
            Bus existingBus = busRepository.findByPlateNumber(bus.getPlateNumber());
            if (existingBus != null) {
                message="Plate number already in use.";
                return new MengedegnaApiResponse<>(null,message,HttpStatus.CONFLICT);
            }
            message="Bus successfully created.";
            return new MengedegnaApiResponse<>(busRepository.save(bus),message,HttpStatus.OK);
        } catch (Exception e) {
            message="Failed to create bus.";
            return new MengedegnaApiResponse<>(null,message,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public List<Bus> getBuses() {
        return busRepository.findAll();
    }

    @Override
    public MengedegnaApiResponse<Bus> getBus(Long id) {
        String message;
         Optional<Bus> temp=busRepository.findById(id);
         if(temp.isPresent()){
             message="fetched";
             return  new MengedegnaApiResponse<>(temp.get(),message,HttpStatus.OK);
         }else{
             message="Unable to find bus record.";
             return  new MengedegnaApiResponse<>(null,message,HttpStatus.NO_CONTENT);
         }

    }

    @Override
    public MengedegnaApiResponse<Bus> updateBus(Bus bus, Long id) {
        String message;
        Bus tempBus=busRepository.findByPlateNumber(bus.getPlateNumber());
        Optional<Bus> tempBus2=busRepository.findById(id);
        if(tempBus2.isPresent()){
            if(tempBus == null){
                tempBus2.get().setPlateNumber(bus.getPlateNumber());
            }else{
                tempBus2.get().setUpdatedAt(bus.getCreatedAt());
                tempBus2.get().setGrade(bus.getGrade());
                tempBus2.get().setTotalSeats(bus.getTotalSeats());;
            }
            message="Successfully updated bus record.";
            return new MengedegnaApiResponse<>(busRepository.save(tempBus2.get()),message,HttpStatus.OK);
        }else{
            message="Unable to find bus record.";
            return new MengedegnaApiResponse<>(null,message,HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public MengedegnaApiResponse<Bus> deleteBus(Long id) {
        Optional<Bus> temp =busRepository.findById(id);
        String message;
        if(temp.isPresent()){
            message="Successfully deleted.";
            busRepository.deleteById(id);
            return new MengedegnaApiResponse<>(null,message,HttpStatus.OK);
        }else{
            message="Unable to find bus record.";
            return new MengedegnaApiResponse<>(null,message,HttpStatus.NO_CONTENT);
        }
    }
}
