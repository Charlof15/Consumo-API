package com.ffm.utilerias.ot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ffm.utilerias.ot.component.Variables;
import com.ffm.utilerias.ot.model.Respuesta;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Services {
	@Autowired
	private Variables variables;
	
	
	public ResponseEntity<Respuesta> obtenerApiRest(String idOt){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
	
		//headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.setBearerAuth(variables.getSessionId());
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<Respuesta> response = restTemplate.exchange("https://apiv3.iucnredlist.org/api/v3/speciescount?token=9bb4facb6d23f48efbf424bb05c0c1ef1cf6f468393bc745d42179ac4aca5fee", HttpMethod.GET, entity,Respuesta.class);
			
			System.err.println(new Gson().toJson(response.getBody()));
			if (response.getStatusCode().is2xxSuccessful()) {
				log.info("Dentro de respuesta exitosa {}", response.getStatusCode());
				log.error("Ejemplo error {}" , "Error");
				return new ResponseEntity<Respuesta>(response.getBody(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(HttpStatus.FAILED_DEPENDENCY);
		}
	}
	
	
}
