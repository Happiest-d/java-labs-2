package org.donstu.controllers;

import org.donstu.domain.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/company")
public class CompanyController {
    private static List<Company> companies = new ArrayList<>();
    static {
        companies.add(new Company("Google", "Best Search Engine", "Mountain View, CA 94043", "+1 650-253-0000"));
        companies.add(new Company("Apple", "Apple Inc.", "Cupertino, CA 95014", "+1 408-996-1010"));
        companies.add(new Company("Microsoft", "Microsoft Corporation", "Redmond, WA 98052", "+1 425-882-8080"));
        companies.add(new Company("Samsung", "Samsung Electronics", "Seoul, Korea", "+82 2 1234 5678"));
        companies.add(new Company("Nokia", "Nokia Corporation", "Helsinki, Finland", "+358 9 123 4567"));
        companies.add(new Company("Sony", "Sony Corporation", "Tokyo, Japan", "+81 3 1234 5678"));
        companies.add(new Company("Yandex", "Yandex LLC", "Moscow, Russia", "+7 499 123 45 67"));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getCompanies();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCompanies() {
        GenericEntity<List<Company>> genericEntity = new GenericEntity<List<Company>>(companies) {};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCompany(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (companies.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(companies.get(num)).build();
        }
    }
}
