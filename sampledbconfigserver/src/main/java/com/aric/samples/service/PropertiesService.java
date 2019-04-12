package com.aric.samples.service;

import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import com.aric.samples.domain.Properties;
import com.aric.samples.repository.PropertiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TTDKOC
 *
 */
@RestController
@RequestMapping("/api")
public class PropertiesService {

	@Autowired
	private PropertiesRepository repository;

	@GetMapping("/props")
	public Iterable<Properties> getAll() {
		return repository.findAll();
	}

	@GetMapping("/props/{application}")
	public Iterable<Properties> get(@PathVariable() String application) {
		return repository.findByApplication(application);
	}

	@GetMapping("/props/{application}/{profile}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile) {
		return repository.findByApplicationAndProfile(application, profile);
	}

	@GetMapping("/props/{application}/{profile}/{label}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label) {
		return repository.findByApplicationAndProfileAndLabel(application, profile, label);
	}

	@GetMapping("/props/{application}/{profile}/{label}/{key}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label, @PathVariable() String key) {
		return repository.findByApplicationAndProfileAndLabelAndKey(application, profile, label, key);
	}

	@PutMapping("/props")
	public Optional<Properties> update(@Valid @RequestBody Properties insuranceProperties) throws URISyntaxException {
		Optional<Properties> existing = repository.findOneByApplicationAndProfileAndLabelAndKey(
				insuranceProperties.getApplication(), insuranceProperties.getProfile(), insuranceProperties.getLabel(),
				insuranceProperties.getKey());
		return existing.map(rProp -> {
			rProp.setValue(insuranceProperties.getValue());
			return repository.save(rProp);
		});
	}

	@PostMapping("/props")
	public Properties create(@Valid @RequestBody Properties insuranceProperties) {
		return repository.save(insuranceProperties);
	}
}
