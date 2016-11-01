package com.melkov.controllers;

import com.melkov.domain.CarImage;
import com.melkov.services.CarImageService;
import com.melkov.utils.ImageResize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 26.10.16.
 */
@Controller("/image")
public class ImageController {

    Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    CarImageService carImageService;

    @RequestMapping(value ="/Test")
    public String test() throws IOException {

        final String inputImagePath = "/home/andrew/intercars/BMW_320_3/bmw_1.jpg";
        final String outputImagePath1 = "/home/andrew/intercars/BMW_320_3/bmw_Fixed.jpg";
        final String outputImagePath2 = "/home/andrew/intercars/BMW_320_3/bmw_Smaller_png.png";
        final String outputImagePath3 = "/home/andrew/intercars/BMW_320_3/bmw_Bigger_png.png";


        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    // resize to a fixed width (not proportional)
                    int scaledWidth = 1024;
                    int scaledHeight = 768;
                    ImageResize.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

                    // resize smaller by 50%
                    double percent = 0.5;
                    ImageResize.resize(inputImagePath, outputImagePath2, percent);

                    // resize bigger by 50%
                    percent = 1.5;
                    ImageResize.resize(inputImagePath, outputImagePath3, percent);

                } catch (IOException ex) {
                    System.out.println("Error resizing the image.");
                    ex.printStackTrace();
                }
            }
        });

        thread.start();


        return "redirect:/getImages";
    }

    @RequestMapping("/upload")
    public String uploadView(){
        return "upload";
    }

    @RequestMapping("/multipleUpload")
    public String uploadMultipleView(){
        return "uploadMultiple";
    }

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(HttpServletRequest request , @RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
//				String rootPath = System.getProperty("glassfish.home");
				String rootPath = request.getSession().getServletContext().getRealPath("/resources/img");
//
                File dir = new File(rootPath + File.separator + "tmpFiles1");

                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + ".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return " 12344 You successfully uploaded file=" + serverFile;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

    /**
     * Upload multiple file using Spring Controller
     */
//    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
//    public @ResponseBody
//    String uploadMultipleFileHandler(@RequestParam("name") String[] names,
//                                     @RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
//
//        if (files.length != names.length)
//            return "Mandatory information missing";
//
//        String message = "";
//        for (int i = 0; i < files.length; i++) {
//            MultipartFile file = files[i];
//            String name = names[i];
//            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
////                String rootPath = System.getProperty("catalina.home");
//                String rootPath = request.getSession().getServletContext().getRealPath("/resources/img");
//
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists())
//                    dir.mkdirs();
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//                logger.info("Server File Location="
//                        + serverFile.getAbsolutePath());
//
//                message = message + " 123 You successfully uploaded file=" + name + " ";
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        }
//        return message;
//    }

    @RequestMapping("/insertImg")
    public String insertImg(
//            @ModelAttribute("uuid") Long uuid,
            @ModelAttribute CarImage carImage,
            HttpServletRequest request){

//        logger.log(Level.SEVERE,request.getAttribute("uuid") + "");


        return "insert_img";
    }


    @RequestMapping("/insertImages")
    public String insertImages(HttpServletRequest request,
                               @ModelAttribute CarImage carImage) throws IOException {
        List<MultipartFile> files = carImage.getFiles();
        int carId = carImage.getCarId();


        logger.log(Level.SEVERE, "files = " + files.toString() + "carId = " + carId);

        logger.log(Level.SEVERE, carImage.toString());

        if (carImage != null){
            carImageService.addImages(carImage);

        }else {
            return "redirect:/getList";
        }

        return "redirect:/getList";
    }

    @RequestMapping("/getImages")
    public void displayImage(@RequestParam int i, HttpServletRequest request, HttpServletResponse response){
        List<MultipartFile> list = carImageService.getImageList(i);
        logger.log(Level.SEVERE, list.toString());

    }

}
