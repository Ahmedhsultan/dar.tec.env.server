package com.dar.tec.env.service;

import com.dar.tec.env.dto.resp.ScriptDTOResp;
import com.dar.tec.env.persistence.repository.ScriptRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScriptService extends BaseService<ScriptRepo, UUID, ScriptDTOResp>{
}
