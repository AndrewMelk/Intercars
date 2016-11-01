package com.melkov.dao.impl;

import com.melkov.dao.CarDao;
import com.melkov.domain.Car;
import com.melkov.domain.SearchBean;
import com.melkov.jdbc.mappers.CarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 05.08.16.
 */
@Repository
public class CarDaoImpl implements CarDao {

    Logger log = Logger.getLogger("CarDaoImpl");
    @Autowired
    DataSource dataSource;

    public Car getCarById(String id) {
        List<Car> carList = new ArrayList<Car>();
        String sql = "select * from car where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        carList = jdbcTemplate.query(sql, new CarRowMapper());
        return carList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Car> getAllCar() {
        List<Car> carList = new ArrayList<Car>();

        String sql = "select * from car";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        carList = jdbcTemplate.query(sql, new CarRowMapper());
        return carList;
    }

    public void addCar(Car car) {
        String sql = "INSERT INTO car "
                + "(user_name, mark, model, engine_value, consumption, vehicle_type, bodyType, carYear" +
                ", carPrice, transmissionType, typeOfDrive, mileage, city, colour, description, title" +
                ", modification, vin, uuid, general_image) VALUES (?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[] {"Andrew", car.getMark(), car.getModel(),
                        car.getEngineValue(), car.getConsumption(), car.getVehicleType(),
                        car.getBodyType(), car.getCarYear(), car.getCarPrice(), car.getTransmissionType(),
                        car.getTypeOfDrive(), car.getMileage(), car.getCity(), car.getColour(),
                        car.getDescription(),car.getTitle(), car.getModeification(), car.getVin(), car.getUuid(), car.getGeneralImage()});
        log.log(Level.SEVERE,"in addCar");
    }




    public void removeCar(String id) {
        String sql = "delete from car where id=" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    public List<Car> getCarsByMark(String mark) {
        List<Car> carList = new ArrayList<Car>();

        String sql = "select * from car where mark=" +"'" + mark + "'";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        carList = jdbcTemplate.query(sql, new CarRowMapper());
        return carList;
    }

    public List<Car> getCarsByParam(String vehicleType,
                                    String bodyType,
                                    String mark,
                                    String model,
                                    double fromEngineValue,
                                    double toEngineValue,
                                    double fromConsumption,
                                    double toConsumption,
                                    int fromCarYear,
                                    int toCarYear,
                                    int fromCarPrice,
                                    int toCarPrice,
                                    String transmissionType,
                                    String typeOfDrive,
                                    int fromMileage,
                                    int toMileage,
                                    String city,
                                    String colour,
                                    String description) {
        List<Car> carList = new ArrayList<Car>();
        StringBuilder sql = new StringBuilder();

        sql.append("select * from car where ");
        if (!vehicleType.equals(null)){
            sql.append("vehicle_type=" +"'" + vehicleType + "'");
        }
        if (!bodyType.equals(null)){
            sql.append("bodyType=" +"'" + bodyType + "'");
        }
        if (!mark.equals(null)){
            sql.append("mark=" +"'" + mark + "'" + " AND ");
        }
        if (!model.equals(null)){
            sql.append("model=" +"'" + model + "'");
        }
        if (fromEngineValue>0&&toEngineValue==0){
            sql.append("engine_value>=" + fromEngineValue);
        }else if (fromEngineValue==0&&toEngineValue<=100){
            sql.append("engine_value<=" + toEngineValue);
        }else if (fromEngineValue>0&&toEngineValue<=100){
            sql.append("engine_value=" + "BETWEEN" + fromEngineValue + "AND" + toEngineValue);
        }
        if (fromConsumption>=0&&toConsumption==0){
            sql.append("consumption>=" + fromConsumption);
        }else if (fromConsumption==0&&toConsumption<=100){
            sql.append("consumption<=" + toConsumption);
        }else if (fromConsumption>0&&toConsumption<=100){
            sql.append("consumption=" + "BETWEEN" + fromConsumption + "AND" + toConsumption);
        }
        if (fromCarYear>=0&&toCarYear==0){
            sql.append("carYear>=" + fromCarYear);
        }else if (fromCarYear==0&&toCarYear<=3000){
            sql.append("carYear<=" + toCarYear);
        }else if (fromCarYear>=1900&&toConsumption<=3000){
            sql.append("carYear=" + "BETWEEN" + fromCarYear + "AND" + toCarYear);
        }
        if (fromCarPrice>=0&&toCarPrice==0){
            sql.append("carPrice>=" + fromCarPrice);
        }else if (fromCarPrice==0&&toCarPrice<=300000){
            sql.append("carPrice<=" + toCarPrice);
        }else if (fromCarPrice>0&&toConsumption<=300000){
            sql.append("carPrice=" + "BETWEEN" + fromCarPrice + "AND" + toCarPrice);
        }
        if (!transmissionType.equals(null)){
            sql.append("transmissionType=" +"'" + transmissionType + "'");
        }
        if (!typeOfDrive.equals(null)){
            sql.append("typeOfDrive=" +"'" + typeOfDrive + "'");
        }
        if (fromMileage>=0&&toMileage==0){
            sql.append("mileage>=" + fromMileage);
        }else if (fromMileage==0&&toMileage<=1000000){
            sql.append("mileage<=" + toMileage);
        }else if (fromMileage>=0&&toConsumption<=1000000){
            sql.append("mileage=" + "BETWEEN" + fromMileage + "AND" + toMileage);
        }
        if (!city.equals(null)){
            sql.append("city=" +"'" + city + "'");
        }
         if (!colour.equals(null)){
            sql.append("colour=" +"'" + colour + "'");
        }

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        carList = jdbcTemplate.query(sql.toString(), new CarRowMapper());
        return carList;
    }



    public List<Car> getCarsByMarkModel(String mark, String model) {

        List<Car> carList = new ArrayList<Car>();
        String sql = "select * from car where mark=" + "'" + mark + "'" + " AND "+ "model="  +"'" + model + "'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        carList = jdbcTemplate.query(sql, new CarRowMapper());
        return carList;
    }

    public void updateData(Car car) {
        String sql = "UPDATE car set mark = ?,model = ?, engine_value = ?, consumption = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[] { car.getMark(), car.getModel(),
                        car.getEngineValue(), car.getConsumption(), car.getId() });
    }

    public List<Car> carListByParameters(SearchBean searchBean){

        List<Car> carList = new ArrayList<Car>();
        StringBuilder sql = new StringBuilder();
        String sqlNew = "SELECT * FROM car ";
        sql.append("SELECT * FROM car WHERE ");

        if (!searchBean.getMark().equals("All")){
            sql.append("mark = " + "'" + searchBean.getMark() + "'" + " ");
        }

        if (!searchBean.getModel().equals("null")){
            sql.append("AND model = " + "'" + searchBean.getModel() + "'");
        }
        if(sql.toString().equals("SELECT * FROM car WHERE ")) {

            if (searchBean.getFromCarYear() != 0) {
                sql.append("carYear BETWEEN 1950 AND " + searchBean.getToCarYear());
            } else if (searchBean.getToCarYear() != 0) {
                sql.append("carYear BETWEEN " + searchBean.getFromCarYear() + "  AND " + Calendar.getInstance().get(Calendar.YEAR));
            } else {
                sql.append("carYear BETWEEN 1950 AND " + Calendar.getInstance().get(Calendar.YEAR));

            }
        }else{
            if (searchBean.getFromCarYear() != 0) {
                sql.append("AND carYear BETWEEN 1950 AND " + searchBean.getToCarYear());
            } else if (searchBean.getToCarYear() != 0) {
                sql.append("AND carYear BETWEEN " + searchBean.getFromCarYear() + "  AND " + Calendar.getInstance().get(Calendar.YEAR));
            } else {
                sql.append("AND carYear BETWEEN 1950 AND " + Calendar.getInstance().get(Calendar.YEAR));

            }
        }


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        if(sql.toString().equals("SELECT * FROM car WHERE ")){
            carList = jdbcTemplate.query(sqlNew, new CarRowMapper());
        }else {

            carList = jdbcTemplate.query(sql.toString(), new CarRowMapper());
        }
        return carList;
    }

}
