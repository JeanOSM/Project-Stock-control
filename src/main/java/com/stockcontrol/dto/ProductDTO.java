package com.stockcontrol.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private Long stockTotal;
    private Date dateCreate;
}
