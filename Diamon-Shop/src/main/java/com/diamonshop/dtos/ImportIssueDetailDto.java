package com.diamonshop.dtos;

import com.diamonshop.entities.ImportIssue;
import com.diamonshop.entities.Product;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImportIssueDetailDto {
    private Integer id;

    private Product product;

    private ImportIssue issue;

    private Integer quantity;

    private LocalDate expiryDate;

    private Double price;
}
