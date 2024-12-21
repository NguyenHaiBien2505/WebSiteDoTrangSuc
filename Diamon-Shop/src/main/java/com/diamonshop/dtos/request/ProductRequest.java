package com.diamonshop.dtos.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductRequest {
    private String name;
    private Integer categoryId;
    private Integer quantity;
    private LocalDate expiryDate;
    private Double price;
    private String productColor;
    private String productDescription;
}
