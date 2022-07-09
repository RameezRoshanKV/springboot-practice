package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.Student;
import com.springboot.repository.MysqlDataSource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FetchStudentDetails {

	private final MysqlDataSource dtsource;
	private Logger log = LoggerFactory.getLogger(FetchStudentDetails.class);

	public FetchStudentDetails(MysqlDataSource dtsource) {
		this.dtsource = dtsource;
	}

	@Operation(summary = "This api is for fetch the details of students from db", tags = "Get")
	@Parameter(name = "id", description = "pass user db id here")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "This api gives full db details", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)) }),
			@ApiResponse(responseCode = "404", description = "Not found - The product was not found", content = @Content) })

	@RequestMapping(value = "/api/v1/fetchstudents", method = RequestMethod.GET)

	public List<Student> fetchStudetDetails() {

		log.debug("request initiated for all students");

		return this.dtsource.fetchAllStudents();
	}

	@Operation(summary = "This api is for fetch the details of students from db based on id", tags = "Get")
	@Parameter(name = "id", description = "pass user db id here")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "This api gives full db details", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)) }),
			@ApiResponse(responseCode = "404", description = "Service not found", content = @Content),
			@ApiResponse(responseCode = "403", description = "unauth request", content = @Content) })

	@RequestMapping(value = "/api/v1/fetchstudentById/{id}", method = RequestMethod.GET)

	public List<Student> fetchStudetDetailsById(@PathVariable String id) {

		log.debug("request initiated for id " + id);

		return this.dtsource.fetchStudentById(id);
	}

	@Operation(summary = "This api is for fetch the details of passout students ", tags = "Post")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "This api gives full db details", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)) }),
			@ApiResponse(responseCode = "404", description = "Service not found", content = @Content),
			@ApiResponse(responseCode = "403", description = "unauth request", content = @Content) })

	@RequestMapping(value = "/api/v1/listPassouts", method = RequestMethod.POST)

	public List<Student> fetchPassOuts() {

		log.debug("request initiated for passouts");
		return this.dtsource.fetchAllPassOuts();

	}

}
