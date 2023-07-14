package com.dar.tec.env.service;

import com.dar.tec.env.dto.resp.PluginDTOResp;
import com.dar.tec.env.persistence.repository.PluginRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PluginService extends BaseService<PluginRepo, UUID, PluginDTOResp> {
}
