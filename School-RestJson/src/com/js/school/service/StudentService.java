package com.js.school.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/studentservice")
public class StudentService {

	@POST
	@Path("/createstudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response welcomMessage(InputStream incomingData) {
		StringBuilder inputString = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				inputString.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + inputString.toString());
		return Response.status(200).build();
	}

	/*
	 * This is the sample format of the json to be returned { "studentslist": [{
	 * "name": "Sriram" }, { "name": "Jaisudha" }] }
	 */
	@GET
	@Path("/getallstudents")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllStudents() {

		JSONArray listOfStudents = new JSONArray();
		JSONObject student = new JSONObject();
		student.accumulate("name", "Sriram");
		listOfStudents.put(student);
		student = new JSONObject();
		student.accumulate("name", "Jaisudha");
		listOfStudents.put(student);

		student = new JSONObject();
		student.accumulate("StudentsList", listOfStudents);

		return student.toString();
	}
}