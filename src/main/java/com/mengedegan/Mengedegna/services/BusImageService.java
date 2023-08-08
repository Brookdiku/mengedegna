package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.Bus;
import com.mengedegan.Mengedegna.entities.BusImage;
import com.mengedegan.Mengedegna.repositories.IBusImageRepository;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BusImageService implements IBusImageService {
    @Autowired
    IBusImageRepository busImageRepository;
    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;
    @Autowired
    IBusService busService;

    @Override
    public MengedegnaApiResponse<BusImage> uploadImage(MultipartFile[] files, Long id) throws IOException {
        String message;
        MengedegnaApiResponse<Bus> bus = busService.getBus(id);
        BusImage busImage;
        if (bus.getData() != null) {
            message = "Successfully uploaded image.";
            for (MultipartFile file : files) {
                BusImage image = busImageRepository.findByBusImageUrl(file.getOriginalFilename());
                if (image != null) {
                    busImage = new BusImage();
                    String fileName = UUID.randomUUID().toString();
                    String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
                    fileName = fileName + extension;
                    File myfile = new File(FILE_DIRECTORY + fileName);
                    myfile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(myfile);
                    fos.write(file.getBytes());
                    fos.close();
                    busImage.setImageUrl(fileName);
                    busImage.setCreatedAt(LocalDateTime.now());
                    return new MengedegnaApiResponse<>(busImageRepository.save(busImage), message, HttpStatus.OK);
                } else {
                    busImage = new BusImage();
                    File myfile = new File(FILE_DIRECTORY + file.getOriginalFilename());
                    myfile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(myfile);
                    fos.write(file.getBytes());
                    fos.close();
                    busImage.setImageUrl(file.getOriginalFilename());
                    busImage.setCreatedAt(LocalDateTime.now());
                    return new MengedegnaApiResponse<>(busImageRepository.save(busImage), message, HttpStatus.OK);
                }
            }
            return new MengedegnaApiResponse<>(null, null, HttpStatus.OK);
        } else {
            message = "No bus record found.";
            return new MengedegnaApiResponse<>(null, message, HttpStatus.NO_CONTENT);
        }


    }

    @Override
    public MengedegnaApiResponse<BusImage> deleteImage(long id) {
        Optional<BusImage> image = busImageRepository.findById(id);
        if (image.isPresent()) {
            busImageRepository.deleteById(id);
            return new MengedegnaApiResponse<>(null, "Successfully deleted Image", HttpStatus.OK);
        } else {
            return new MengedegnaApiResponse<>(null, "Unable to find Image", HttpStatus.NO_CONTENT);
        }
    }
}
