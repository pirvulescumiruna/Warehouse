package org.acme.services;

import org.acme.repositories.ProductRepository;
import org.acme.repositories.StoreRepository;
import org.acme.resources.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import java.util.List;

@ApplicationScoped
public class StoreService {

    @Inject
    StoreRepository storeRepository;
    @Inject
    ProductRepository productRepository;

    public List<Store> getAllStores() {
        return storeRepository.listAll();
    }

    public Store insert(Store store)  {
        System.out.println(store.getProducts());
        storeRepository.persist(store);
        return store;
    }

    public boolean delete(Long id) {
        return storeRepository.deleteById(id);
    }

    public Store update(Store store) {
        Store storeToUpdate = new Store();
        try {storeToUpdate = storeRepository.findById(store.getId());
            System.out.println(storeToUpdate);
            storeToUpdate.setCity(store.getCity());
            storeToUpdate.setName(store.getName());
            storeRepository.persist(storeToUpdate);
        }
        catch (NullPointerException e) {

        }

        return storeToUpdate;

    }

    public int insertProductToStore(Integer storeId, Integer productId){
        return storeRepository.linkProductToStore(storeId, productId);
    }


}

