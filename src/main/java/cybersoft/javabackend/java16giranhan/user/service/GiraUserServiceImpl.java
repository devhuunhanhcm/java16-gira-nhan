package cybersoft.javabackend.java16giranhan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giranhan.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giranhan.user.mapper.GiraUserMapper;
import cybersoft.javabackend.java16giranhan.user.model.GiraUser;
import cybersoft.javabackend.java16giranhan.user.repository.GiraUserRepository;
@Service
public class GiraUserServiceImpl implements GiraUserService {
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private GiraUserRepository repository;
	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);
		//encoder password before save
		user.setPassword(encoder.encode(dto.getPassword()));
		
		GiraUser newUser = repository.save(user);
		
		newUser.setPassword("");
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

}
