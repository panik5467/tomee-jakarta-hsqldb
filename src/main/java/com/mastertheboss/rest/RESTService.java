package com.mastertheboss.rest;

import com.mastertheboss.ejb.ServiceBean;
import com.mastertheboss.model.SimpleProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ArrayList;


@Path("/api")
public class RESTService {


	@Inject
	ServiceBean ejb;

	@GET
	@Path("/list/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyByPathParam(@PathParam("id") String id)
	{
		return ejb.findById(id);
	}

	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeByIdParam(@PathParam("id") String id)
	{
		ejb.deleteById(id);
		return id + ": deleted";
	}

	@GET
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeAll()
	{
		ejb.deleteAll();
		return "All deleted";
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SimpleProperty> getProperty()
	{
		return ejb.findAll();
	}

	@GET
	@Path("/records")
	public String listRecords()
	{
		List<SimpleProperty> list = ejb.findAll();
		List<String> array = new ArrayList<String>();
		
		array.add ("<th style='border: 1px solid black;'>Id</th><th>Value</th>");
		for (SimpleProperty row : list)
			array.add ("<td style='border: 1px solid black;'>" + row.getKey() + "</td><td>" + row.getValue() + "</td>");

		StringBuilder sb = new StringBuilder("<body style='margin: 4rem;background: #E0E0E0;'>");
		sb.append("<table style='border-collapse: collapse;table-layout: auto;width: 180px;text-align: center;'>");
		sb.append ("<caption>Liste: " + list.size() + " valeurs</caption>");
		for (String row : array)
			sb.append("<tr style='border: 1px solid black;'>" + row + "</tr>");
		sb.append("</table>").append("</body>");
			
		return sb.toString();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response createProperty(@FormParam("key")String key,
								   @FormParam("value")String value)
	{
		ejb.put(key,value);

		return Response.ok("Inserted! Go back and check the list.").build();

	}

}