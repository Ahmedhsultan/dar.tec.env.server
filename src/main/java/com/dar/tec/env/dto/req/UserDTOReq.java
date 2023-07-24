package com.dar.tec.env.dto.req;

import lombok.Data;

@Data
public class UserDTOReq {
    private String password;
    private String name;
    private String email;
}
