package com.cloudxpert.oauth2.rest.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * StudentResource
 */
@Validated
@Data
public class StudentResource {

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	public StudentResource id(Integer id) {
		this.id = id;
		return this;
	}

	public StudentResource firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}


	public StudentResource lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}



	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
