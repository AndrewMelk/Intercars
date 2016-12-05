package com.melkov.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 23.11.16.
 */
public class ImageUpload {

    Logger logger = Logger.getLogger(this.getClass().toString());

    public boolean upload(HttpServletRequest request, MultipartFile[] files, long tmpUUID){
        boolean isUploaded = false;

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];

            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
                String rootPath = request.getSession().getServletContext().getRealPath("/resources/images");

                File dir = new File(rootPath + File.separator + "tmpFiles" + File.separator + tmpUUID);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
                if (!serverFile.equals(null)){
                    isUploaded = true;
                }else {
                    isUploaded = false;
                }

            } catch (Exception e) {
                logger.log(Level.SEVERE, "------insert method Exception-----" + e.toString());
//				return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return isUploaded;
    }
}
