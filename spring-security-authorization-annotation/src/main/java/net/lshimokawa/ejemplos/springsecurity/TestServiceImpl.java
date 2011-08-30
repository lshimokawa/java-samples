package net.lshimokawa.ejemplos.springsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String testAdmin() {
		return "testAdmin";
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public String testUser() {
		return "testUser";
	}

}