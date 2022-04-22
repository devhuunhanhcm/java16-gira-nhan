package cybersoft.javabackend.java16giranhan.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16giranhan.common.util.ErrorHelper;
import cybersoft.javabackend.java16giranhan.common.util.ResponseHelper;
import cybersoft.javabackend.java16giranhan.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giranhan.user.service.GiraUserService;
@RestController
@RequestMapping("/api/v1/users")
public class GiraUserController {
	@Autowired
	private GiraUserService service;
	
	@PostMapping
	public Object createNewUser( @RequestBody @Valid  GiraUserDTO dto,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		GiraUserDTO newUser = service.createNewUser(dto);
		
		return ResponseHelper.getResponse(newUser, HttpStatus.OK);
	}
}
