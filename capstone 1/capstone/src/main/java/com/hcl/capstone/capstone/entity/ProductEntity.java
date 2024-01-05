package com.hcl.capstone.capstone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity{
    @Id
    int id =0;
    String name="";
    double price=0;
    double discountedPrice=0;
    String strDate="";

}
