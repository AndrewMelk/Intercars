package com.melkov.controllers;

import com.melkov.domain.*;
import com.melkov.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@SessionAttributes({"mark","model"})
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
	@Autowired
	CityService cityService;
	@Autowired
	RegionService regionService;



	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public ModelAndView getData(@ModelAttribute SearchBean searchBean) {


		List<Car> carList = carService.getAllCar();
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		List<CarMarks> notTopCarMarksList = carMarksService.getNotTopMarks();

		ModelAndView model = new ModelAndView("index");

		model.addObject("carMarksList", carMarksList);
		model.addObject("carList", carList);
		model.addObject("notTopCarMarksList", notTopCarMarksList);
		model.addObject("newCar", new Car());

		return model;

	}

	@RequestMapping("/add_car")
	public ModelAndView addCar(@ModelAttribute Car car) {
		ModelAndView model = new ModelAndView("add_car");

		List<String> vehicleType = new ArrayList<String>();
		List<String> bodyType = new ArrayList<String>();
		List<String> transmissionTypes = new ArrayList<String>();
		List<String> typeOfDrive = new ArrayList<String>();
		List<Integer> carYears = new ArrayList<Integer>();
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		List<Region> regionList = regionService.getListRegions();

		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 1950; i<=year; i++){
			carYears.add(i);
		}


		vehicleType.add("Мототехника");
		vehicleType.add("Легковой");
		vehicleType.add("Грузовой");
		vehicleType.add("Автобусы");

		bodyType.add("Хетчбек");
		bodyType.add("Седан");
		bodyType.add("Универсал");
		bodyType.add("Купе");

		transmissionTypes.add("Механическая");
		transmissionTypes.add("Роботизированная");
		transmissionTypes.add("Автоматическая");
		transmissionTypes.add("Вариатор");

		typeOfDrive.add("Передний");
		typeOfDrive.add("Задний");
		typeOfDrive.add("Полный");

		model.addObject("vehicleType", vehicleType);
		model.addObject("bodyType", bodyType);
		model.addObject("carYears", carYears);
		model.addObject("transmissionTypes", transmissionTypes);
		model.addObject("carMarksList", carMarksList);
		model.addObject("typeOfDrive", typeOfDrive);
		model.addObject("regionList", regionList);
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
	public @ResponseBody List<Car> showUsedCarByParam(@RequestParam String mark,
										   @RequestParam String model){

		List<Car> carList = carService.getCarsByMarkModel(mark, model);
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		ModelAndView mav = new ModelAndView("usedList");
//		request.getSession().setAttribute("mark",mark);
//		request.getSession().setAttribute("model",model);
		mav.addObject("carMarksList", carMarksList);
		mav.addObject("carList", carList);

		return carList;

	}

//	@RequestMapping("/usedBySearchBean")
//	public @ResponseBody ModelAndView usedBySearchBean(@ModelAttribute SearchBean searchBean){
//		List<Car> carList = carService.carListByParameters(searchBean);
//		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
//
//		ModelAndView mav = new ModelAndView("usedList");
////		ModelAndView mav = new ModelAndView("TestJson");
//
//		mav.addObject("carMarksList", carMarksList);
//		mav.addObject("carList", carList);
//
//		return mav;
//	}

	@RequestMapping("/usedBySearchBean")
	public @ResponseBody List<Car> usedBySearchBean(@ModelAttribute SearchBean searchBean){
		List<Car> carList = carService.carListByParameters(searchBean);
//		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
//
//		ModelAndView mav = new ModelAndView("usedList");
////		ModelAndView mav = new ModelAndView("TestJson");
//
//		mav.addObject("carMarksList", carMarksList);
//		mav.addObject("carList", carList);

		return carList;
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

	@RequestMapping("/loadRegions")
	public @ResponseBody List<Region> loadRegions(String region){
		return regionService.getListRegions();
	}


	@RequestMapping("/loadCity")
	public @ResponseBody List<City> loadCity(@RequestParam(value = "id", required = true) int id){
		return cityService.getCityList(id);
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