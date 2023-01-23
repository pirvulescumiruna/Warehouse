package org.acme;

import io.agroal.api.AgroalDataSource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("/hello")
public class GreetingResource {

    @Inject
    AgroalDataSource agroalDataSource;

    @POST
    @Path("/insert")
    public boolean insert() throws SQLException{
            Connection con = agroalDataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO test(name) VALUES ('Ciocan')");
            System.out.println("AM REUSIT");
            return preparedStatement.execute();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        Connection con = agroalDataSource.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO test(name) VALUES ('Ciocan')");
        preparedStatement.execute();
        System.out.println("AM REUSIT");
        return "MS DE AJUTOR AM REUSIT <3";
    }

}