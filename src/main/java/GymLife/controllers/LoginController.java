package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.LoginRequest;
import GymLife.model.response.LoginResponse;
import GymLife.persistent.entity.User;
import GymLife.services.impl.ServicesImpl;
import GymLife.utils.SessionToken;
import GymLife.service.IServices;

@RestController
public class LoginController {
	
private IServices service = new ServicesImpl();
	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse login(@Valid @RequestBody LoginRequest login, Errors errors){
		
		
		
		LoginResponse response = new LoginResponse();
		if(errors.hasErrors()){
			response.setEsito(false);
			response.setDescrizione("INPUT NON VALIDI");
			
			return response;
		}
		
		String email = login.getEmail();
		String password = login.getPassword();
		
		User result = service.login(email);
		if(result == null){
			response.setEsito(false);
			response.setDescrizione("UTENTE NON ESISTENTE");
			
			return response;
		}
		if(password.equals(result.getPassword())){
			response.setEsito(true);
			response.setDescrizione("LOGIN AVVENUTO CON SUCCESSO");
			response.setToken_sessione(SessionToken.getSessionToken());
			response.setNome(result.getNome());
			
			return response;
		}
		response.setEsito(false);
		response.setDescrizione("PASSWORD NON CORRETTA");
		
		return response; 
	}
	
}
