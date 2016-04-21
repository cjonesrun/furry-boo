package com.sarcastico.as.rs;

import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sarcastico.interceptors.Audit;
import com.sarcastico.interceptors.Logging;
import com.sarcastico.as.impl.Item;
import com.sarcastico.as.impl.ItemServiceBean;
import com.sarcastico.as.impl.Service;

@Path("/cbn")
public class App2Endpoints {

	@Inject
    private ItemServiceBean itemService;
	
	@Inject
	Service svc;
	
	@GET
	@Path("/x")
	@Produces({ "application/json" })
	@Audit
    @Logging
	public String doGet()
	{
		JsonObjectBuilder j = Json.createObjectBuilder();
		j.add("result", svc.createMessage("cbn/x from " + this.getClass().getSimpleName()));
		
		List<Item> items = itemService.getList();
		if (items != null && !items.isEmpty())
		{
			JsonObjectBuilder j2 = Json.createObjectBuilder();
			for (Item i : items)
			{
				j2.add(i.getId().toString(), i.getName());
			}
			j.add("items", j2);
		}
		
		return j.build().toString();
	}
}
