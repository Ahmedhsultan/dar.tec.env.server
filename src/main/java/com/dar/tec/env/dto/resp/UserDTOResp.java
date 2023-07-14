package com.dar.tec.env.dto.resp;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTOResp {
    private UUID uuid;
    private String userName;
    private String password;
    private String name;
    private String email;
}
