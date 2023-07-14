package com.dar.tec.env.persistence.repository;

import com.dar.tec.env.persistence.entity.Category;
import com.dar.tec.env.persistence.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category, UUID> {
    Optional<Category> findByName(String categoryName);
}
