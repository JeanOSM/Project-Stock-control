package com.stockcontrol.service;

import com.stockcontrol.dto.ProductDTO;
import com.stockcontrol.entity.Product;
import com.stockcontrol.mapper.ProductMapper;
import com.stockcontrol.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public ProductDTO save(ProductDTO productDTO) {
        Product product = new Product();
        product = dtoToEntity(productDTO);
        product.setDateCreate(new Date());
        product = productRepository.save(product);
        productDTO = entityToDto(product);
        return productDTO;
    }

    public Product dtoToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setStockTotal(productDTO.getStockTotal());
        product.setDateCreate(productDTO.getDateCreate());
        return product;
    }

    public ProductDTO entityToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setId(product.getId());
        productDTO.setStockTotal(product.getStockTotal());
        productDTO.setDateCreate(product.getDateCreate());
        return productDTO;
    }
    public String delete(Long id){
        if(findById(id)!=null) {
            productRepository.deleteById(id);
            if (findById(id) == null) {
                return "Produto excluido com sucesso!";
            }
            else
                return "Falha ao excluir, verifique novamente;";
        }
        else
            return  "Produto Inexistente!";
    }
    public ProductDTO findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return entityToDto(product.get());
        }
        else
            return null;
    }


}
