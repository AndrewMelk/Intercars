package com.melkov.controllers;

import com.melkov.domain.*;
import com.melkov.services.*;
import com.melkov.utils.ImageUpload;
import com.melkov.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.metamodel.ListAttribute;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@SessionAttributes({"mark","model"})
@RequestMapping(value = "/")
public class MainController {
	Logger logger = Logger.getLogger(getClass().toString());


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


	@RequestMapping("/")
	public String redirect(){
		return "redirect:/carList";
	}


	@RequestMapping(value = "/carList", method = RequestMethod.GET)
	public ModelAndView getData(@ModelAttribute SearchBean searchBean) {


		List<Car> cars = carService.getAllCar();
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		List<CarMarks> notTopCarMarksList = carMarksService.getNotTopMarks();
		List<Integer> carYears = new ArrayList<Integer>();
		List<String> bodyType = new ArrayList<String>();
		List<String> transmissionTypes = new ArrayList<String>();

		bodyType.add("Хетчбек");
		bodyType.add("Седан");
		bodyType.add("Универсал");
		bodyType.add("Купе");

		transmissionTypes.add("Механическая");
		transmissionTypes.add("Роботизированная");
		transmissionTypes.add("Автоматическая");
		transmissionTypes.add("Вариатор");

		ModelAndView model = new ModelAndView("used_cars");

		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year; i>=1950; i--){
			carYears.add(i);
		}
		model.addObject("transmissionTypes", transmissionTypes);
		model.addObject("bodyType", bodyType);
		model.addObject("carYears",carYears);
		model.addObject("carMarksList", carMarksList);
		model.addObject("cars", cars);
		model.addObject("notTopCarMarksList", notTopCarMarksList);
		model.addObject("newCar", new Car());

		return model;

	}

	@RequestMapping("/add_car")
	public ModelAndView addCar(@ModelAttribute Car car, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("add_car");


		List<String> vehicleType = new ArrayList<String>();
		List<String> bodyType = new ArrayList<String>();
		List<String> transmissionTypes = new ArrayList<String>();
		List<String> typeOfDrive = new ArrayList<String>();
		List<Integer> carYears = new ArrayList<Integer>();
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		List<Region> regionList = regionService.getListRegions();



		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year; i>=1950; i--){
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
	public String inserData(@ModelAttribute Car car,
							@RequestParam("file") MultipartFile[] files,
							HttpServletRequest request,
							ModelAndView mav) {

		logger.log(Level.SEVERE, car.toString());

		if (car != null) {
			car.setUsername(request.getParameter(""));

			List<Car> carList = carService.getAllCar();
			long tmpUUID = 0;
			long uuid;
			if(carList.isEmpty()){
				tmpUUID = UUIDGenerator.createRandomUUID();
				car.setUuid(tmpUUID);

				logger.log(Level.SEVERE, " if car.setUuid(UUIDGenerator.createRandomUUID());" + car.getUuid());
			}else {
				for (Car car1 : carList) {
					tmpUUID = UUIDGenerator.createRandomUUID();
					uuid = car1.getUuid();
					if (uuid != tmpUUID) {
						car.setUuid(tmpUUID);
//					request.setAttribute("uuid", uuid);
					}
				}
			}
			logger.log(Level.SEVERE, "tmpUUID: ---- " + tmpUUID);

			car.setGeneralImage("/resources/images/tmpFiles/" + File.separator+tmpUUID+File.separator + files[0].getOriginalFilename());


			//-------------insert images with UUID--------------

			String message = "";
			ImageUpload imageUpload = new ImageUpload();
			if(imageUpload.upload(request,files,tmpUUID)){
				carService.addCar(car,"/resources/images/tmpFiles/" + File.separator+tmpUUID+File.separator + files[0].getOriginalFilename());
			}
			//---------------END insert images with UUID----------

			mav.addObject("carId", car.getId());
		}else {
			return "redirect:/carList";
//			return "redirect:/insertImg";
		}
		return "redirect:/carList";
	}



	@RequestMapping("/delete")
	public String deleteCar(@RequestParam String id, HttpServletRequest request){
		System.out.println("id= " + id);
		carService.removeCar(id);
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/img");
		File file = new File(rootPath + File.separator + "tmpFiles1" + File.separator + "11.jpg");
		if (file.delete()){
			logger.log(Level.SEVERE, "deleted file: " + file);
		}else {
			logger.log(Level.SEVERE, "file don't deleted " + file);

		}
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
	public @ResponseBody ModelAndView showUsedCarByParam(@RequestParam String mark,
										   @RequestParam String model){

		List<Car> carList = carService.getCarsByMarkModel(mark, model);
		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		ModelAndView mav = new ModelAndView("Test");
//		request.getSession().setAttribute("mark",mark);
//		request.getSession().setAttribute("model",model);
		mav.addObject("carMarksList", carMarksList);
		mav.addObject("carList", carList);

		return mav;

	}


	@RequestMapping(value = "/usedBySearchBean",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			method = RequestMethod.GET)
	public @ResponseBody List<Car> usedBySearchBean(@ModelAttribute SearchBean searchBean){

//		ModelAndView mav = new ModelAndView("index1");
		List<Car> carList = carService.carListByParameters(searchBean);
//		mav.addObject("carList" , carList);
		logger.log(Level.SEVERE, carList.toString());
		return carList;
	}

	@RequestMapping(value = "/usedCars", method = RequestMethod.GET)
	public ModelAndView usedCars(@ModelAttribute SearchBean searchBean){
		ModelAndView mav = new ModelAndView("used_cars");
		List<Car> cars = carService.carListByParameters(searchBean);
		mav.addObject("cars",cars);
		logger.log(Level.SEVERE,cars.toString());
		return mav;
	}

	@RequestMapping("/dropdown")
	public @ResponseBody List<CarMarks> loadMarks(){

		List<CarMarks> carMarksList = carMarksService.getTopCarMarks();
		ModelAndView model = new ModelAndView("dropdown");
		model.addObject("carMarksList", carMarksList);


		return carMarksList;
	}



	@RequestMapping(value = "/loadModels", method = RequestMethod.GET)
	public @ResponseBody
	List<CarModels> loadModels(@RequestParam(value = "mark", required = true) String mark){

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


	@RequestMapping(value = "/test/cookie", method = RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView("test1");

		return mav;
	}










}




