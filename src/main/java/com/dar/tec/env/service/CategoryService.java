package com.dar.tec.env.service;

import com.dar.tec.env.dto.resp.CategoryDTOResp;
import com.dar.tec.env.exception.CreationException;
import com.dar.tec.env.persistence.entity.Category;
import com.dar.tec.env.persistence.repository.CategoryRepo;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryRepo, UUID, CategoryDTOResp>{
    private CategoryRepo categoryRepo;
    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public void add(String categoryName){
        Category category = new Category();
        category.setName(categoryName);

        try {
            categoryRepo.save(category);
        }catch (Exception e){
            e.printStackTrace();

            //Check duplication of this name
            if (e.getMessage().contains("Duplicate entry"))
                throw new CreationException("This category is existed!!");

            //Throw for other reason
            throw new CreationException("Can't add the new category!!");
        }
    }
}
