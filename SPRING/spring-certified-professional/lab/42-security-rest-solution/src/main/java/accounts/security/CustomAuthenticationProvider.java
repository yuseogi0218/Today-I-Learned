package accounts.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

      String username = authentication.getName();
      String password = authentication.getCredentials().toString();

      if (!checkCustomAuthenticationSystem(username, password)) {
      	throw new BadCredentialsException("Bad credentials provided");
      }
      
      return new UsernamePasswordAuthenticationToken(
              username, password, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
  }


  @Override
  public boolean supports(Class<?> authentication) {
      return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

  // Use custom authentication system for the verification of the
  // passed username and password.  (Here we are just faking it.)
  private boolean checkCustomAuthenticationSystem(String username, String password) {
      return username.equals("spring") && password.equals("spring");
  }
}