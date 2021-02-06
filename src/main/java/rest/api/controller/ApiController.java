package rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.api.model.ApiModel;
import rest.api.repositories.ApiRepositories;

@RestController
@RequestMapping(value = "/api/v1", consumes = "application/json")
public class ApiController {

	@Autowired
	ApiRepositories ar;

	@PostMapping(value = "/getdatasp")
	public Object getApi(@RequestBody ApiModel request) {
		return ar.getData(request);
	}
}
