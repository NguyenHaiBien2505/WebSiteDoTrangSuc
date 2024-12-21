package com.diamonshop.dtos.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExportProductRequest {
    private Integer productId;
    private Integer quantity;
}
