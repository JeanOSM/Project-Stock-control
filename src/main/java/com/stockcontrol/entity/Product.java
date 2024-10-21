package com.stockcontrol.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="PRODUCT")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "STOCK_TOTAL")
    private Long stockTotal;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE")
    private Date dateCreate;

}

