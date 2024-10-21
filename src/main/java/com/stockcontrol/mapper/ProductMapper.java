package com.stockcontrol.mapper;

import com.stockcontrol.dto.ProductDTO;
import com.stockcontrol.entity.Product;

public class ProductMapper {
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
}
