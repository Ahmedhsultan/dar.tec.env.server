package com.dar.tec.env.service;

import com.dar.tec.env.dto.resp.UserDTOResp;
import com.dar.tec.env.persistence.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends BaseService<UserRepo, UUID, UserDTOResp>{
}
