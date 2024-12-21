package com.diamonshop.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hanghoa")
@ToString
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "name")
    private String name;
    
    @Column(name = "color")
    private String productColor;

    @Column(name = "description")
    private String productDescription;
    
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}


