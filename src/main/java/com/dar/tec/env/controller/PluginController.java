package com.dar.tec.env.controller;

import com.dar.tec.env.dto.resp.PluginDTOResp;
import com.dar.tec.env.service.PluginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("plugin")
public class PluginController extends BaseController<UUID, PluginService, PluginDTOResp>{
}
