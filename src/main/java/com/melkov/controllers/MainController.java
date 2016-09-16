package com.melkov.controllers;

import com.melkov.domain.Car;
import com.melkov.domain.CarMarks;
import com.melkov.domain.CarModels;
import com.melkov.domain.User;
import com.melkov.services.CarMarksService;
import com.melkov.services.CarModelsService;
import com.melkov.services.CarService;
import com.melkov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/")
public class MainController {

	Logger logger = Logger.getLogger(getClass().toString());

	@Autowired
	UserService userService;

	@Autowired
	CarService carService;
	@Autowired
	CarMarksService carMarksService;
	@Autowired
	CarModelsService carModelsService;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public ModelAndView getData() {


		List<Car> carList = carService.getAllCar();
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();

		ModelAndView model = new ModelAndView("index");

		model.addObject("carMarksList", carMarksList);
		model.addObject("carList", carList);
		model.addObject("newCar", new Car());

		return model;

	}

	@RequestMapping("/add_car")
	public ModelAndView addCar(@ModelAttribute Car car) {
		ModelAndView model = new ModelAndView("add_car");

		List<String> vehicleType = new ArrayList<String>();
		List<String> bodyType = new ArrayList<String>();

		vehicleType.add("Мототехника");
		vehicleType.add("Легковой");
		vehicleType.add("Грузовой");
		vehicleType.add("Автобусы");

		bodyType.add("Хетчбек");
		bodyType.add("Седан");
		bodyType.add("Универсал");
		bodyType.add("Купе");

		model.addObject("vehicleType", vehicleType);
		model.addObject("bodyType", bodyType);
		return model;
	}


	@RequestMapping("/insert")
	public String inserData(@ModelAttribute Car car) {
		if (car != null) {
			carService.addCar(car);
		}else {
			return "redirect:/getList";

		}

		return "redirect:/getList";
	}

	@RequestMapping("/delete")
	public String deleteCar(@RequestParam String id){
		System.out.println("id= " + id);
		carService.removeCar(id);

		return "redirect:/getList";
	}

	@RequestMapping("/edit")
	public ModelAndView editCar(@RequestParam String id,
								@ModelAttribute Car car){

		car = carService.getCarById(id);

		Map<String,Object> map = new HashMap<String, Object>();

		map.put("car",car);

		return new ModelAndView("edit","map",map);

	}

	@RequestMapping("/update")
	public String updateCar(@ModelAttribute Car car){
		carService.updateData(car);
		return "redirect:/getList";
	}

	@RequestMapping("/show_details")
	public ModelAndView showDetails(@RequestParam String id,
									@ModelAttribute Car car){
		car = carService.getCarById(id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("car", car);
		return  new ModelAndView("car_details","map",map);
	}

	@RequestMapping("/used")
	public ModelAndView showUsedCarByMark(@RequestParam String mark){
		List<Car> carList = carService.getCarsByMark(mark);
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();

		ModelAndView model = new ModelAndView("usedList");

		model.addObject("carMarksList", carMarksList);
		model.addObject("carList", carList);

		return model;
	}

	@RequestMapping("/usedByParam")
	public ModelAndView showUsedCarByParam(@RequestParam String vehicleType,
										   @RequestParam String bodyType,
										   @RequestParam String mark,
										   @RequestParam String model,
										   @RequestParam double fromEngineValue,
										   @RequestParam double toEngineValue,
										   @RequestParam double fromConsumption,
										   @RequestParam double toConsumption,
										   @RequestParam int fromCarYear,
										   @RequestParam int toCarYear,
										   @RequestParam int fromCarPrice,
										   @RequestParam int toCarPrice,
										   @RequestParam String transmissionType,
										   @RequestParam String typeOfDrive,
										   @RequestParam int fromMileage,
										   @RequestParam int toMileage,
										   @RequestParam String city,
										   @RequestParam String colour,
										   @RequestParam String description){
		List<Car> carList = carService.getCarsByParam(vehicleType, bodyType, mark, model, fromEngineValue, toEngineValue, fromConsumption, toConsumption,
				fromCarYear, toCarYear, fromCarPrice, toCarPrice, transmissionType, typeOfDrive, fromMileage, toMileage, city, colour, description);
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();

		ModelAndView mav = new ModelAndView("usedList");

		mav.addObject("carMarksList", carMarksList);
		mav.addObject("carList", carList);

		return mav;
	}
	@RequestMapping("/usedByMarkModel")
	public ModelAndView showUsedCarByParam(@RequestParam String mark,
										   @RequestParam String model){

		List<Car> carList = carService.getCarsByMarkModel(mark, model);
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		ModelAndView mav = new ModelAndView("usedList");

		mav.addObject("carMarksList", carMarksList);
		mav.addObject("carList", carList);

		return mav;

	}


	@RequestMapping("/dropdown")
	public ModelAndView loadMarks(){

		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();

		ModelAndView model = new ModelAndView("dropdown");

		model.addObject("carMarksList", carMarksList);


		return model;
	}

	@RequestMapping(value = "/loadModels", method = RequestMethod.GET)
	public @ResponseBody
	List<CarModels> loadModels(@RequestParam(value = "mark", required = true) String mark){
//		ModelAndView model = new ModelAndView();
//		List<CarModels> carModelsList = new ArrayList<CarModels>();
//		carModelsList = carModelsService.getModelsByMark(mark);

//		model.addObject("carModelsList",carModelsList);

		return carModelsService.getModelsByMark(mark);

	}

	@RequestMapping(value = "/loadModels1", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView loadModelsByMark(@RequestParam(value = "mark", required = true) String mark){
		ModelAndView model = new ModelAndView("models");
		List<CarModels> carModelsList = new ArrayList<CarModels>();
		carModelsList = carModelsService.getModelsByMark(mark);

		model.addObject("carModelsList",carModelsList);

		return model;

	}

	@RequestMapping("/uploadPage")
	public ModelAndView uploadPage(){
		ModelAndView mav = new ModelAndView("uploadPAge");
		return mav;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(
			@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File("/home/andrew/testUpload/" + "123.png"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
			ImageIO.write(src, "png", destination);
			//Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
			return "redirect:/getList";
		}return "redirect:/getList";
	}

	@RequestMapping(value = "/loginform")
	public ModelAndView login(@ModelAttribute User user){
		logger.log(Level.SEVERE, "in /login");
		return new ModelAndView("login");

	}

	@RequestMapping(value = "/loginUser",method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User user){
		logger.log(Level.SEVERE,"in loginUser action");
		String page;
		if (userService.validUser(user)){

			page = "redirect:/getList";
		}else {
			page = "redirect:/loginform";

		}
		return page;
	}
}