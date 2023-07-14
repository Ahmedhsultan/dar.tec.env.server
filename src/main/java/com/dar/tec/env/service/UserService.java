package com.dar.tec.env.service;

import com.dar.tec.env.dto.req.UserCredintialsDTO;
import com.dar.tec.env.dto.req.UserDTOReq;
import com.dar.tec.env.dto.resp.UserDTOResp;
import com.dar.tec.env.exception.UserException;
import com.dar.tec.env.persistence.entity.User;
import com.dar.tec.env.persistence.repository.UserRepo;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends BaseService<UserRepo, UUID, UserDTOResp>{
    private UserRepo userRepo;
    private ModelMapper modelMapper;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
        this.modelMapper = new ModelMapper();
    }
    public void signup(UserDTOReq userDTOReq){
        User user = modelMapper.map(userDTOReq, User.class);
        try {
            userRepo.save(user);
        }catch (PersistenceException persistenceException){
            persistenceException.printStackTrace();
            throw new UserException("Failed to sign up");
        }
    }
    public void login(UserCredintialsDTO userCredintialsDTO){
        Optional<User> userOptional = userRepo.findByUserName(userCredintialsDTO.userName());
        if (!userOptional.isPresent())
            throw new UserException("Credential is wrong!!");
        if (!userOptional.get().getPassword().equals(userCredintialsDTO.password()))
            throw new UserException("Credential is wrong!!");
    }
}
