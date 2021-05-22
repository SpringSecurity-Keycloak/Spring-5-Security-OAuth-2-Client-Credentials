package com.todaystech.oauth2.rest.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * StudentResource
 */
@Validated
@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResource {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;


}
