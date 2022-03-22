package cybersoft.javabackend.java16giranhan.role.service;

import java.util.List;

import cybersoft.javabackend.java16giranhan.role.dto.GiraGroupDTO;

public interface GiraGroupService {
	List<GiraGroupDTO> findAllDto();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
}
