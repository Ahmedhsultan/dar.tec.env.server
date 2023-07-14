package com.dar.tec.env.dto.resp;

import com.dar.tec.env.persistence.entity.Plugin;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CategoryDTOResp {
    private UUID uuid;
    private String name;
    private Set<Plugin> plugins;
}
