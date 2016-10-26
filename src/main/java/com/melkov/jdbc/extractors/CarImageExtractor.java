package com.melkov.jdbc.extractors;

import com.melkov.domain.CarImage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 19.10.16.
 */
public class CarImageExtractor implements ResultSetExtractor<CarImage> {
    Logger logger = Logger.getLogger(this.getClass().toString());

    public CarImage extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        CarImage carImage = new CarImage();
        List<MultipartFile> list = new ArrayList<MultipartFile>();

        while (resultSet.next()){
            logger.log(Level.SEVERE, String.valueOf(resultSet.getByte("image")));
            Blob blob = resultSet.getBlob("image");
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);

//release the blob and free up memory. (since JDBC 4.0)
//            blob.free();



            MultipartFile file;
// list.add(file);
        }
        logger.log(Level.SEVERE, list.toString());
        carImage.setFiles(list);

        return carImage;
    }
}
