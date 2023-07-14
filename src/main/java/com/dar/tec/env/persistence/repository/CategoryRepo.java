package com.dar.tec.env.persistence.repository;

import com.dar.tec.env.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category, UUID> {
}
