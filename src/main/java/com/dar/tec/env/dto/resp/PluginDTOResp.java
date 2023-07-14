package com.dar.tec.env.dto.resp;

import com.dar.tec.env.persistence.entity.Category;
import lombok.Data;

import java.util.UUID;

@Data
public class PluginDTOResp {
    private UUID uuid;
    private Category category;
}
