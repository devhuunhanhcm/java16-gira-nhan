package cybersoft.javabackend.java16giranhan.security.service;


import cybersoft.javabackend.java16giranhan.security.dto.LoginDTO;

public interface AuthService {
	String login(LoginDTO dto);
}
