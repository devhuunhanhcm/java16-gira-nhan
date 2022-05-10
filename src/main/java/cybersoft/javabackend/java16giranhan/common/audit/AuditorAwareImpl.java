package cybersoft.javabackend.java16giranhan.common.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorAwareImpl implements AuditorAware<String> {
	
	//getCurrentAuditor là user đang login
	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth == null)
			return Optional.ofNullable("");
		//handle 2 việc Obtains the currently authenticated principal,
		//or an authentication request token.
		
		if(auth.getPrincipal() instanceof String) {
			return Optional.ofNullable((String) auth.getPrincipal());
		}
		
		UserDetails currentAuditor = (UserDetails) auth.getPrincipal();
		
		return Optional.ofNullable(currentAuditor.getUsername());
	}

}
