package cybersoft.javabackend.java16giranhan.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16giranhan.common.util.ErrorHelper;
import cybersoft.javabackend.java16giranhan.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giranhan.role.model.GiraRole;
import cybersoft.javabackend.java16giranhan.role.service.GiraRoleService;

@RestController
@RequestMapping("/roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object  findAllRoles() {
		List<GiraRole> roles =  service.findAllEntity();
		return new ResponseEntity<>(roles,HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleDTO dto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(ErrorHelper.getAllError(bindingResult)
					,HttpStatus.BAD_REQUEST);
			
		}
		
		
		GiraRole role = service.save(dto);
		return new ResponseEntity<>(role,HttpStatus.CREATED);
	}
}
