package br.com.restapi.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restapi.repository.UserRepository;
import br.com.restapi.security.AccountCredentialVO;
import br.com.restapi.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserRepository repository;

	@ApiOperation(value = "Autentica usuario de acordo com as credenciais")
	@PostMapping(value = "/signin", produces = { "application/json", "application/xml",
			"application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity signin(@RequestBody AccountCredentialVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

			var user = repository.findByUsername(username);

			var token = "";

			if (user != null) {
				token = tokenProvider.createToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username " + username + " not foiund!");
			}

			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);

			return ok(model);

		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Você informou usuario ou senha invalido");
		}
	}

}
