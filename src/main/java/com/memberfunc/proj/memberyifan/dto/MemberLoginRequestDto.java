package com.memberfunc.proj.memberyifan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequestDto {

    private String username;

    private String password;
}
