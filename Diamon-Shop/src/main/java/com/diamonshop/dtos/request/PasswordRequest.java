package com.diamonshop.dtos.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PasswordRequest {
    private String oldPassword;
    private String newPassword;
}
