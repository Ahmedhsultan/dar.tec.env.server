package com.dar.tec.env.controller;

import com.dar.tec.env.dto.resp.ScriptDTOResp;
import com.dar.tec.env.service.ScriptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("script")
public class ScriptController extends BaseController<UUID, ScriptService, ScriptDTOResp>{
}
