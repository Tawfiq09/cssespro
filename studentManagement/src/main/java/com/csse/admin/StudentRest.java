package com.csse.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.csse.db.utill.DAOManager;
import com.csse.db.utill.StudentDAO;
import com.csse.student.registration.DAOType;


@Path("/admin.student")
public class StudentRest {
	
	@GET
	@Path("student")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response studentService() {
		Response response = Response.status(Response.Status.ACCEPTED).build();
		try {
			response = Response.status(Response.Status.OK).entity("{\"msg\":\"successful!\"}").build();
		} catch (Exception ex) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			System.out.println(ex.getMessage());
		}

		return response;
	}
	
	@POST
	@Path("student/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response studentSaveService(String consumeJson) {
		Response response = Response.status(Response.Status.ACCEPTED).build();
		try {
			DAOManager dmger =new DAOManager();
			StudentDAO sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
			sdao.saveStudent(consumeJson);
			response = Response.status(Response.Status.OK).entity("{\"msg\":\"successful!\"}").build();
		} catch (Exception ex) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			System.out.println(ex.getMessage());
		}

		return response;
	}
	
	@POST
	@Path("student/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response studentUpdateService(String consumeJson) {
		Response response = Response.status(Response.Status.ACCEPTED).build();
		try {
			DAOManager dmger =new DAOManager();
			StudentDAO sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
			sdao.updateStudent(consumeJson);
			response = Response.status(Response.Status.OK).entity("{\"msg\":\"successful!\"}").build();
		} catch (Exception ex) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			System.out.println(ex.getMessage());
		}

		return response;
	}
	
	@DELETE
	@Path("student/delete/{nic}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response studentDeleteService(@PathParam("nic") String nic) {
		Response response = Response.status(Response.Status.ACCEPTED).build();
		try {
			DAOManager dmger =new DAOManager();
			StudentDAO sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
			//sdao.deleteStudent(nic);
			response = Response.status(Response.Status.OK).entity("{\"msg\":\"successful!\"}").build();
		} catch (Exception ex) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			System.out.println(ex.getMessage());
		}

		return response;
	}

}
