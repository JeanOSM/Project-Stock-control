package com.stockcontrol.controller;

import com.stockcontrol.dto.ProductDTO;
import com.stockcontrol.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        productDTO = productService.save(productDTO);
        if(productDTO.getId()!= null){
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping(value = "/")
    public ResponseEntity<String> delete(@RequestParam Long id){
        String delete = productService.delete(id);
        if(delete.equals("Produto excluido com sucesso!")){
            return ResponseEntity.status(HttpStatus.OK).body(delete);
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(delete);

    }
}
