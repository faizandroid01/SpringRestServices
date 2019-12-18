package com.faiz.learn.webcontrollers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.learn.model.DynamicFilterBean;
import com.faiz.learn.model.FilterBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FillteringController {

	@GetMapping("/filter")
	public FilterBean getBean() {
		return new FilterBean("Val1", "Val2", "Val3");
	}

	@GetMapping("/filterFromList")
	public List<DynamicFilterBean> getBeanList() {
		return Arrays.asList(new DynamicFilterBean("Val1", "Val2", "Val3"),
				new DynamicFilterBean("Val12", "Val22", "Val32"));
	}

	@GetMapping("/dynamicFiltering")
	public MappingJacksonValue retrieveBinDynamically() {

		DynamicFilterBean bean = new DynamicFilterBean("field 1", "filed 2", "field 3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("val1", "val2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFiltering", filter);

		MappingJacksonValue mappingJackson = new MappingJacksonValue(bean);
		mappingJackson.setFilters(filters);

		return mappingJackson;

	}

}
