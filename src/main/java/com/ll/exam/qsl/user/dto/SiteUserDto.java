package com.ll.exam.qsl.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteUserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
}
