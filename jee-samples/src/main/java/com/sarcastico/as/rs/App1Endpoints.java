package com.sarcastico.as.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sarcastico.as.impl.Service;

@Path("/cbn")
public class App1Endpoints {

	@Inject
	Service svc;
	
	@GET
	@Path("/x")
	@Produces({ "application/json" })
	public String doGet()
	{
		return "{\"result\":\"" + svc.createMessage("cbn/x from " + this.getClass().getSimpleName()) +"\"}";
	}
}
