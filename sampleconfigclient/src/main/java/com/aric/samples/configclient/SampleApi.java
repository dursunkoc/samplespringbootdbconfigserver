/**
 * 
 */
package com.aric.samples.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TTDKOC
 *
 */
@RestController
@RequestMapping(path = "/api")
public class SampleApi {
	@Value("${name_x.property_xx}")
	private String aConf;
	
	@GetMapping
	public String getConf() {
		return this.aConf;
	}
}
