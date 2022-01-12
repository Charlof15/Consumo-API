package com.ffm.utilerias.ot.utility;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.http.impl.client.HttpClientBuilder;

import com.ffm.utilerias.ot.component.Configuraciones;
import com.ffm.utilerias.ot.component.Variables;
import com.ffm.utilerias.ot.mapper.ConfirmacionMapper;
import com.ffm.utilerias.ot.model.ws.upsf.InputUpSF;
import com.ffm.utilerias.ot.service.ConfirmacionService;
import com.ffm.utilerias.ot.service.EnviarInputSf;
import com.google.gson.Gson;


@Service
public class LlamadaApiIntegracionSf  {
	
	@Autowired
	private Variables var;
	
	@Autowired
	private ConfirmacionService service;
	
	
	public ResponseEntity<String> requestApi(String idFolio, Integer esConfirmada){
		
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		EnviarInputSf jsonSf = new EnviarInputSf();
		
		List<InputUpSF> list = jsonSf.InputSf(idFolio, esConfirmada);
		HttpClient httpClient = HttpClientBuilder.create().build();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));    
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(var.getSessionId());
		HttpEntity<String> requestEntity = new HttpEntity<String>(new Gson().toJson(list), headers);
		System.err.println(requestEntity.getBody());
		ResponseEntity<String> responseEntity=restTemplate.exchange(service.configuraciones().get("URL_SOBJECT_SF").getValor(), HttpMethod.PATCH, requestEntity, String.class);	
		System.err.println(responseEntity.getStatusCode());
		System.err.println("Fuera de salesforce");
		return responseEntity;
	}

}
