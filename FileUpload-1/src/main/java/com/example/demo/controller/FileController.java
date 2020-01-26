package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class FileController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ModelAndView getList() {

		ModelAndView view = new ModelAndView("image/Image");
		view.addObject("users", userService.findAll());
		view.addObject("user", new User());

		return view;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") MultipartFile file) {
		
	//	System.out.println("ModelMap :"+ request.getAttribute("name")); null qaytarir 
		
		User user=new User();
		
		user.setFile(file.getOriginalFilename());
		
		userService.save(user);
		
	//	System.out.println("  2  ******************"+file.getOriginalFilename()); excel-icon.png qaytarir
		
		return "image/fileUploadView";
	}

	// @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	// public String submit(@RequestParam("file") MultipartFile file, ModelMap
	// modelMap,
	// @ModelAttribute("user") User user) {

	// String file2 = file.getOriginalFilename();

	// System.out.println("String file2 = file.getOriginalFilename(); --------****"
	// + file2);

	// System.out.println("User: ----------------- ****" + user);

	// user.setFile(file2);

	// userService.save(user);

	// modelMap.addAttribute("file", file);

	// return "image/fileUploadView";
	// }

	/////////////////////////////////

	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public String submit(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {

		modelMap.addAttribute("files", files);

		return "image/fileUploadView2";
	}

	@PostMapping("/uploadFileWithAddtionalData")
	public String submit(@RequestParam MultipartFile file, @RequestParam String name, @RequestParam String surname,
			ModelMap modelMap) {

		modelMap.addAttribute("name", name);
		modelMap.addAttribute("surname", surname);
		modelMap.addAttribute("file", file);
		return "image/fileUploadView2";
	}

}
