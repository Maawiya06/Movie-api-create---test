package com.Movies.API.Controller;

import com.Movies.API.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class fileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadfile")
    public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file){

        try{
            // validation
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Choose a file for upload");
            }

            // custome file
            if(!file.getContentType().equals("/image/png")){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("ONly upload PNG file");
            }

            // file upload code
            Boolean f = fileUploadHelper.uploadfile(file);
            if(f){
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some Thing Went Wrong !!! Try Again");
    }
}
