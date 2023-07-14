package com.dar.tec.env.persistence.repository;

import com.dar.tec.env.persistence.entity.Script;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScriptRepo extends JpaRepository<Script, UUID> {
}
