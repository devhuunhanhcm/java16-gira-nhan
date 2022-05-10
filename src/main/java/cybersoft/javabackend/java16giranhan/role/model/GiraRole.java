package cybersoft.javabackend.java16giranhan.role.model;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giranhan.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="gira_role")
public class GiraRole extends BaseEntity{
	@Size(min = 5,max =100,message="Role code must be longer than 5 characters.")
	private String code;
	@NotBlank(message="Description must be not blank")
	private String description;
	
	
	@ManyToMany(mappedBy = "roles")
	private Set<GiraGroup> groups = new LinkedHashSet();
}
