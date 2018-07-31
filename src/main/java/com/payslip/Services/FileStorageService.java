package com.payslip.Services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class FileStorageService {

    public Resource loadFileAsResource(String fileName, Path storageLocation) {
        System.out.println("Storage Location "+storageLocation);
        System.out.println(fileName);
        Resource resource = null;
        try {
            Path filePath = storageLocation.resolve(fileName).normalize();
             resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                System.out.println("file Path StorageService "+filePath);
                System.out.println("File not found " + fileName);
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
return  resource;
    }
}
