package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.resources.Store;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class StoreRepository implements PanacheRepository<Store> {

   public int linkProductToStore(Integer storeId, Integer productId){
       return getEntityManager().createNamedQuery("INSERT INTO store_to_product VALUES (" + storeId + "," + productId + ")").executeUpdate();
   }
}
