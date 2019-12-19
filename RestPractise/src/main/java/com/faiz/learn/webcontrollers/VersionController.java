package com.faiz.learn.webcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.model.versionModel.FullName;
import com.faiz.learn.model.versionModel.Name;
import com.faiz.learn.model.versionModel.SegregatedName;

@RestController
public class VersionController {

	/* Based on different Uri */
	@GetMapping(value = "/person/v1")
	public FullName personUri1() {
		return new FullName("Faiz Ahmed");
	}

	@GetMapping(value = "/person/v2")
	public SegregatedName personUri2() {
		return new SegregatedName(new Name("Faiz", "Ahmed"));
	}

	/* Request Params */
	@GetMapping(value = "/person/param", params = "version=1")
	public FullName person1() {
		return new FullName("Faiz Ahmed");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public SegregatedName person2() {
		return new SegregatedName(new Name("Faiz", "Ahmed"));
	}

	/* Headers */

	@GetMapping(value = "/person/headers", headers = "API-VERSION=1")
	public FullName personHeader1() {
		return new FullName("Faiz Ahmed");
	}

	@GetMapping(value = "/person/headers", headers = "API-VERSION=2")
	public SegregatedName personHeader2() {
		return new SegregatedName(new Name("Faiz", "Ahmed"));
	}

	/* Based on produces and acceptance */

	@GetMapping(value = "/person/produces", produces = "application/vnd.faiz.app-v1+json")
	public FullName personProduces1() {
		return new FullName("Faiz Ahmed");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.faiz.app-v2+json")
	public SegregatedName personProduces2() {
		return new SegregatedName(new Name("Faiz", "Ahmed"));
	}

}
