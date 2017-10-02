package com.csse.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/admin.student")
public class StudentRest {
	
	@GET
	@Path("student")
	//@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response studentService() {
		Response response = Response.status(Response.Status.ACCEPTED).build();
		try {
			System.out.println("dsdsdsfdsdedfe");
			response = Response.status(Response.Status.OK).entity("{\"msg\":\"goody\"}").build();
		} catch (Exception ex) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			System.out.println(ex.getMessage());
		}

		return response;
	}

}
