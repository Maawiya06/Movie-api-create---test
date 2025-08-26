package com.Movies.API.helper;

import jdk.jfr.Experimental;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:\\Users\\lenovo\\Downloads\\my-movies-api\\my-movies-api\\src\\main\\resources\\static\\image";

    public Boolean uploadfile(MultipartFile multipartFile) {
        boolean f = false;

        try{
            // read data
            InputStream is = multipartFile.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);

            // write data
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
            fos.write(data);

            fos.flush();
            fos.close();

            f = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }
}
