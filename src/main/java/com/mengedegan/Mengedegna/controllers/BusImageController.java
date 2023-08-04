package com.mengedegan.Mengedegna.controllers;
import com.mengedegan.Mengedegna.entities.BusImage;
import com.mengedegan.Mengedegna.services.IBusImageService;
import com.mengedegan.Mengedegna.services.IBusService;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
public class BusImageController {
    @Autowired
    IBusService busService;
    @Autowired
    IBusImageService busImageService;
    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    @PostMapping("/buses/upload")
    public MengedegnaApiResponse<BusImage> fileUpload(@RequestParam("File") MultipartFile[] files, @RequestParam("id") Long id) throws IOException {
        return busImageService.uploadImage(files, id);
    }

    @DeleteMapping("/buses/images/{id}")
    public MengedegnaApiResponse<BusImage> deleteBusImage(@PathVariable("id") Long id) {
        return busImageService.deleteImage(id);
    }
}
