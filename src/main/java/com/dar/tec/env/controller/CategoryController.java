package com.dar.tec.env.controller;

import com.dar.tec.env.dto.req.CategoryDTOReq;
import com.dar.tec.env.dto.resp.CategoryDTOResp;
import com.dar.tec.env.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("category")
public class CategoryController extends BaseController<UUID, CategoryService, CategoryDTOResp> {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("add")
    public ResponseEntity add(@RequestBody CategoryDTOReq categoryDTOReq) {
        categoryService.add(categoryDTOReq.categoryName());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
