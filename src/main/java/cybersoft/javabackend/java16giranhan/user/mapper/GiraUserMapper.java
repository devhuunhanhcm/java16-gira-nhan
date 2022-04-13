package cybersoft.javabackend.java16giranhan.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giranhan.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giranhan.user.model.GiraUser;

@Mapper
public interface GiraUserMapper {
	GiraUserMapper INSTANCE = Mappers.getMapper(GiraUserMapper.class);
	GiraUser toModel(GiraUserDTO dto);
	GiraUserDTO toDto(GiraUser user);	
}
