package cybersoft.javabackend.java16giranhan.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraRoleDTO {
	@Size(min = 5,max =5,message="Role code must be 5 characters.")
	private String code;
	@NotBlank(message="Description must be not blank")
	private String description;
	
}
