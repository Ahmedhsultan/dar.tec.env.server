package com.dar.tec.env.controller;

import com.dar.tec.env.dto.req.UserCredintialsDTO;
import com.dar.tec.env.dto.req.UserDTOReq;
import com.dar.tec.env.dto.resp.UserDTOResp;
import com.dar.tec.env.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<UUID, UserService, UserDTOResp>{
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody UserDTOReq userDTOReq){
        userService.signup(userDTOReq);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody UserCredintialsDTO userCredintialsDTO) {
        userService.login(userCredintialsDTO);

        return ResponseEntity.ok().build();
    }
}
