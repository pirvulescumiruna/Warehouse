package org.acme.controllers;

import org.acme.resources.Store;
import org.acme.services.StoreService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Path("/store")
public class StoreController {

    @Inject
    StoreService storeService;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> getAllStores(){
        return storeService.getAllStores();
    }
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Store insertStore(Store store) {
        LOGGER.info("Store:" + store.getCity() + store.getName() + store.getProducts());
        storeService.insert(store);
         return store;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public boolean deleteStore(Long id){
         return storeService.delete(id);
    }

    @PUT
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Store updateStore(Store store){
        return storeService.update(store);
    }
    @POST
    @Transactional
    @Path("/{storeId}/{productId}")
    public int insertProductToStore(Integer storeId, Integer productId){
          return storeService.insertProductToStore(storeId, productId);
   }
   }


