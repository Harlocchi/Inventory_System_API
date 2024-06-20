package com.example.Stock2.VOs;

import com.example.Stock2.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductSale extends Product {

    private Integer Quantity;

}
