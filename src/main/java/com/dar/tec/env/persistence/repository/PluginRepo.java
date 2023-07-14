package com.dar.tec.env.persistence.repository;

import com.dar.tec.env.persistence.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PluginRepo extends JpaRepository<Plugin, UUID> {
//    List<Plugin> findAllByCategoryNameContains(String categoryName);
    Optional<Plugin> findByName(String name);
}
