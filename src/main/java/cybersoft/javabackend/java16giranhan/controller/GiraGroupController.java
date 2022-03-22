package cybersoft.javabackend.java16giranhan.controller;

import java.util.List;

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
import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giranhan.role.service.GiraGroupService;

@RestController
@RequestMapping("/groups")
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	
	@GetMapping
	public Object findAllGroup() {
		List<GiraGroupDTO> groups = service.findAllDto();
		
		return new ResponseEntity<>(groups,HttpStatus.OK);
	}
	@PostMapping
	public Object createNewGroup(@Valid @RequestBody GiraGroupDTO dto,
								BindingResult result) {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(ErrorHelper.getAllError(result),HttpStatus.BAD_REQUEST);
		}
		GiraGroupDTO group = service.createNewGroup(dto);
		
		return new ResponseEntity<>(group,HttpStatus.CREATED);
	}
}
