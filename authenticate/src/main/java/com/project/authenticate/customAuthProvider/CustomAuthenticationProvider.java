package com.project.authenticate.service;
import com.project.authenticate.entity.Customer;
import com.project.authenticate.repository.*;
import org.springframework.stereotype.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private CustomerService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Customer user = userService.loadUserByUsername(username);

		if (user == null || !password.equals(user.getPassword())) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
