package com.aric.samples.repository;

import java.util.List;
import java.util.Optional;

import com.aric.samples.domain.Properties;

import org.springframework.data.repository.CrudRepository;

/**
 * @author TTDKOC
 *
 */
public interface PropertiesRepository extends CrudRepository<Properties, Long> {

	public List<Properties> findByApplication(String application);

	public List<Properties> findByApplicationAndProfile(String application, String profile);

	public List<Properties> findByApplicationAndProfileAndLabel(String application, String profile, String label);

	public List<Properties> findByApplicationAndProfileAndLabelAndKey(String application, String profile,
			String label, String key);

	public Optional<Properties> findOneByApplicationAndProfileAndLabelAndKey(String application, String profile,
			String label, String key);

}
