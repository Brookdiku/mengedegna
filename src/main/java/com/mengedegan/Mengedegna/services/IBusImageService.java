package com.mengedegan.Mengedegna.services;

import com.mengedegan.Mengedegna.entities.BusImage;
import com.mengedegan.Mengedegna.utilities.MengedegnaApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IBusImageService {
    MengedegnaApiResponse<BusImage> uploadImage(MultipartFile[]files,Long id) throws IOException;

    MengedegnaApiResponse<BusImage> deleteImage(long id);
}
