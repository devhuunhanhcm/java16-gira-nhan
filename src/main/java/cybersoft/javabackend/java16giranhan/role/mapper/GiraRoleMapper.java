package cybersoft.javabackend.java16giranhan.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giranhan.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giranhan.role.model.GiraRole;

@Mapper 	
public interface GiraRoleMapper {
							//interface
	GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	
	//đây là interface muốn dùng đc thì phải có íntance của nó -> thuộc tính INSTANCE
	//chính là một instance nó sẽ dùng thằng 
	//mapper của mappstruct tạo ra instance trả ra  về cho mình sài \
	
	
	GiraRole mappToEntity(GiraRoleDTO dto);
}
