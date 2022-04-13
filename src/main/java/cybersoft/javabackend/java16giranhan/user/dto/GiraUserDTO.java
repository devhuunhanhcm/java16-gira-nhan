package cybersoft.javabackend.java16giranhan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giranhan.user.model.UserStatus;
import cybersoft.javabackend.java16giranhan.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
	//mandatory: những cái bắt buộc phải có 
	@Size(min = 3,max = 100,message="{user.username.size}")
	@UniqueUsername(message = "{}")
	@NotBlank
	private String username;
	
	private String password;
	
	private String displayName;
	
	private String email;
	
	private UserStatus userStatus;
	
	
}
