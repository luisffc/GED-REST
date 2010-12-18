/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.soaexpert.ged.resource;

import br.com.soaexpert.ged.domain.Documento;
import br.com.soaexpert.ged.repository.DocumentoDao;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */

@Path("docs")
public class DocResources {
    @Context
    private UriInfo context;
    private DocumentoDao dao;

    /** Creates a new instance of DocResources */
    public DocResources() {
        dao = new DocumentoDao();
    }

    /**
     * Retrieves representation of an instance of br.com.soaexpert.ged.resource.DocResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Documento getXml(@PathParam("id") Long id) {
        return dao.findById(id);
//        Documento doc = new Documento();
//        return doc;
//        return new Documento();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Documento> getAll(){
        return dao.findAll();
    }

    /**
     * PUT method for updating or creating an instance of DocResources
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Documento putXml(Documento documento) {
        dao.save(documento);
        return documento;
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void delete(Documento documento){
        dao.remove(documento);
    }


}
