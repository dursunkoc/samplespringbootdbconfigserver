/**
 * 
 */
package com.aric.samples.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author TTDKOC
 *
 */
@Entity
@Table(schema="CONFIG")
@Data
public class Properties implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747531716778688077L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROPERTIES")
	@SequenceGenerator(name="SEQ_PROPERTIES", schema="CONFIG", sequenceName="SEQ_PROPERTIES_ID", allocationSize=1)
	private Long id;
	private String application;
	private String profile;
	private String label;
	private String key;
	private String value;
}
