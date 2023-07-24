package com.dar.tec.env.controller;

import com.dar.tec.env.dto.req.PluginDTOReq;
import com.dar.tec.env.dto.resp.PluginDTOResp;
import com.dar.tec.env.persistence.entity.Plugin;
import com.dar.tec.env.service.PluginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;

@Controller
@RequestMapping("plugin")
public class PluginController extends BaseController<UUID, PluginService, PluginDTOResp>{
    private PluginService pluginService;
    public PluginController(PluginService pluginService){
        this.pluginService = pluginService;
    }

    @GetMapping("bycategory")
    public ResponseEntity<List<Plugin>> getByCategory(@RequestParam String categoryName){
        List<Plugin> plugins = pluginService.getByCategory(categoryName);

        return ResponseEntity.ok(plugins);
    }

    @PostMapping(value = "add")
    public ResponseEntity add(@RequestBody PluginDTOReq pluginDTOReq){
        pluginService.add(pluginDTOReq);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
