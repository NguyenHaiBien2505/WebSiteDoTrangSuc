package com.diamonshop.dtos;

import com.diamonshop.entities.Category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private int productId;
    private String name;
    private Category category;
    private int quantity;
    private String productColor;
    private String productDescription;
}