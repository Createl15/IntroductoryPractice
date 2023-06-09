package com.example.zlatik.service;

import com.example.zlatik.entity.Product;
import com.example.zlatik.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository jsonRepo;

    public ProductService(IProductRepository iProductRepository) {
        this.jsonRepo = iProductRepository;
    }

    public List<Product> getList() {
        return jsonRepo.findAll();
    }

    @Async
    public void saveNewProduct() {
        Product newP = new Product();
        jsonRepo.save(newP);
        System.out.println("Create new empty object");
    }

    @Async
    public void deleteProduct(String id) {
        jsonRepo.delete(Long.parseLong(id));
    }

    @Async
    public Product getProductID(String id) {
        return jsonRepo.getByID(Long.parseLong(id));
    }

    @Async
    public Product update(Product product) {
        jsonRepo.update(product);
        return jsonRepo.getByID(product.getId());
    }
}