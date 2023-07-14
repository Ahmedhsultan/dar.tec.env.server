package com.dar.tec.env.persistence.repository;

import com.dar.tec.env.persistence.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PluginRepo extends JpaRepository<Plugin, UUID> {
}
