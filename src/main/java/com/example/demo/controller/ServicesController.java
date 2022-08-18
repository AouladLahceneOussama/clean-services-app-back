package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employees;
import com.example.demo.model.ServiceImages;
import com.example.demo.model.Services;
import com.example.demo.repository.ServiceImagesRepository;
import com.example.demo.repository.ServicesRepository;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api")
public class ServicesController {

	@Autowired
	private ServicesRepository ServicesRepository;

	@Autowired
	private ServiceImagesRepository serviceImagesRepository;

	private static String imageDirectory = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

	// method to create the upload image folder if doesnt exist
	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	// get All services
	@GetMapping("services")
	public List<Services> getAllServices() {
		return ServicesRepository.findAll();
	}

	@GetMapping("services/{id_emp}")
	public ResponseEntity<List<Services>> getServicesById(@PathVariable String id_emp) {
		List<Services> Services = ServicesRepository.getServicesByusername(id_emp);
		return ResponseEntity.ok(Services);
	}

	@PutMapping("services/update/{id_ser}")
	public ResponseEntity<Services> updateService(@PathVariable Long id_ser,
			@RequestParam("statut") String statut) {

		Services service = ServicesRepository.findById(id_ser).orElseThrow();
		service.setStatut(statut);
		System.out.println(statut);

		Services updatedService = ServicesRepository.save(service);
		return ResponseEntity.ok(updatedService);
	}

	@PostMapping(value = "services/addService", produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
	public ResponseEntity<String> addService(
			@RequestParam("employee") Employees employee,
			@RequestParam("service_name") String service_name, @RequestParam("service_parent") String service_parent,
			@RequestParam("prix") int prix,
			@RequestParam("description") String description, @RequestParam("city") String city,
			@RequestParam("statut") String statut,
			@RequestParam("images") MultipartFile[] images) {

		//create the directory if not exist of images
		makeDirectoryIfNotExist(imageDirectory);

		//store the new service and get the it id 
		Services newService;
		Services s = new Services(employee, service_name, service_parent, prix, description, city, statut);
		newService = ServicesRepository.save(s);

		//add images to db and to images folder
		ServiceImages serviceImage;
		for (int i = 0; i < images.length; i++) {
			int index = images[i].getOriginalFilename().lastIndexOf('.');
			String ext = images[i].getOriginalFilename().substring(index + 1);

			int randomNumber = (int) Math.floor(Math.random() * 1000);
			String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "."+ ext;

			Path fileNamePath = Paths.get(imageDirectory, newImageName);
			// System.out.println(newImageName);
			serviceImage = new ServiceImages(newService,newImageName);

			try {
				Files.write(fileNamePath, images[i].getBytes());
				serviceImagesRepository.save(serviceImage);
			} catch (IOException ex) {
				System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
			}
		}

		return ResponseEntity.ok("ok");
	}

	// get services by Ids
	@GetMapping("services/favorite/{ids}")
	public List<Services> getFavoriteServices(@PathVariable String ids) {
		System.out.println(ids);
		String[] split = ids.split(",");
		return ServicesRepository.getFavoriteServices(split);
	}
}
