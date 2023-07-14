package com.dar.tec.env.controller;

import com.dar.tec.env.dto.resp.CategoryDTOResp;
import com.dar.tec.env.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("category")
public class CategoryController extends BaseController<UUID, CategoryService, CategoryDTOResp>{
}
