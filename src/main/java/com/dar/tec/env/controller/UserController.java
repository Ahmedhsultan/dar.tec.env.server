package com.dar.tec.env.controller;

import com.dar.tec.env.dto.resp.UserDTOResp;
import com.dar.tec.env.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<UUID, UserService, UserDTOResp>{
}
