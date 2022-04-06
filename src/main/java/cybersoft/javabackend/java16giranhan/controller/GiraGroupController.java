package cybersoft.javabackend.java16giranhan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16giranhan.common.util.ErrorHelper;
import cybersoft.javabackend.java16giranhan.common.util.ResponseHelper;
import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupWithRoleDTO;
import cybersoft.javabackend.java16giranhan.role.service.GiraGroupService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/groups")
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	
	@GetMapping
	public Object findAllGroup() {
		log.info("find all groups STARTED");
		
		log.debug("calling GiraGroupService.findAllDto()");
		List<GiraGroupDTO> groups = service.findAllDto();
		
		log.debug("result {} ", groups);
		
		log.info("find all groups ENDED");
		return ResponseHelper.getResponse(groups, HttpStatus.OK);
	}
	@PostMapping
	public Object createNewGroup(@Valid @RequestBody GiraGroupDTO dto,
								BindingResult result) {
		
		if(result.hasErrors()) {
			return ResponseHelper.getErrorResponse(result, HttpStatus.BAD_REQUEST);
		}
		GiraGroupDTO group = service.createNewGroup(dto);
		
		return ResponseHelper.getResponse(group, HttpStatus.CREATED);
	}
	@PostMapping("add-role/{group-id}/{role-id}")
	public Object addRole(@PathVariable(name="group-id") String groupId
			,@PathVariable(name="role-id") String roleId) {
		
			GiraGroupWithRoleDTO modifiedGroup = service.addRole(groupId,roleId); 
			
			if(modifiedGroup == null) {
				return ResponseHelper.getErrorResponse("Group or Role is not existing"
									,HttpStatus.BAD_REQUEST);
			}
		
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK);
	}
	@PostMapping("remove-role/{group_id}/{role_id}")
	public Object removeRole(@PathVariable(name = "group_id") String groupId,
			@PathVariable(name="role_id") String roleId) {
		GiraGroupWithRoleDTO modifiedGroup = service.removeRole(groupId,roleId);
		if(modifiedGroup == null) {
			return ResponseHelper.getErrorResponse("Group or Role is not existing", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK);
	}
}
