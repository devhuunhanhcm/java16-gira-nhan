package cybersoft.javabackend.java16giranhan.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupWithRoleDTO;
import cybersoft.javabackend.java16giranhan.role.model.GiraGroup;
@Mapper
public interface GiraGroupMapper {
	GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);
	
	GiraGroupDTO toDTO(GiraGroup model);
	GiraGroup toModel(GiraGroupDTO dto);
	GiraGroupWithRoleDTO toDtoWithRole(GiraGroup modifiedGroup);
}
