package org.kit.spring_ecom.service;

import org.kit.spring_ecom.model.Product;
import org.kit.spring_ecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private  ProductRepo repo;
    
       public  List<Product> getproducts() {
           return repo.findAll();
       }
        // public List<Product> getproducts() {
        //     List<Product> products = repo.findAll();
        //     System.out.println("Fetched products: " + products);
        //     return products;
        // }
    
        

        public Product getProductById(int id) {
            return repo.findById(id).get(); //SINCE WE ARE HANDLE EXCEPTION FROM THE HANDLER SO EMPTY THE GET()
            
        }



        public Product addProductOrUpdateProduct(Product product, MultipartFile image) throws IOException {
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            product.setImageData(image.getBytes());
            return repo.save(product);
        }


//WE CAN USE ONE METHOD TO ADD OR UPDATE PRODUCT
        // public Product updateProduct(Product product, MultipartFile image) throws IOException {

        //     product.setImageName(image.getOriginalFilename());
        //     product.setImageType(image.getContentType());
        //     product.setImageData(image.getBytes());
        //     return repo.save(product);
        // }



        public void deleteProductById(int id) {
          repo.deleteById(id);
        }



        public List<Product> searchProduct(String keyword) {
            return repo.searchProduct(keyword);
        }

}
