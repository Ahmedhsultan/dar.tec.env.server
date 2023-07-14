package com.dar.tec.env.dto.resp;

import lombok.Data;

import java.util.UUID;

@Data
public class ScriptDTOResp {
    private UUID uuid;
    private String excutedcodeURL;
    private String videoURL;
    private String description;
}
