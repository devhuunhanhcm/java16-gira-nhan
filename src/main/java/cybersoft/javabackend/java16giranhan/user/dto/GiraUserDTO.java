package cybersoft.javabackend.java16giranhan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giranhan.user.model.UserStatus;
import cybersoft.javabackend.java16giranhan.user.validation.annotation.UniqueEmail;
import cybersoft.javabackend.java16giranhan.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class GiraUserDTO {
	@Size(min = 3, max = 100, message = "{user.username.size}")
	@UniqueUsername(message = "{user.username.existed}")
	@NotBlank
	private String username;
	
	private String password;
	
	private String displayName;
	
	@NotBlank
	@UniqueEmail(message = "{user.email.existed}")
	private String email;
	
	private UserStatus status;
}
