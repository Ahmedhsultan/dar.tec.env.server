package com.dar.tec.env.service;

import com.dar.tec.env.dto.resp.CategoryDTOResp;
import com.dar.tec.env.persistence.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryRepo, UUID, CategoryDTOResp>{
}
