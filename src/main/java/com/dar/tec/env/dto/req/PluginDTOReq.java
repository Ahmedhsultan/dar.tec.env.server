package com.dar.tec.env.dto.req;

import org.springframework.web.multipart.MultipartFile;

public record PluginDTOReq (String categoryName, String pluginName, String excutedcodeURL, MultipartFile file, String description){
}
