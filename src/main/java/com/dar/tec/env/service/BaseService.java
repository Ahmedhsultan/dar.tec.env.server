package com.dar.tec.env.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class BaseService <Repo extends JpaRepository, ID, DTOResp>{
    @Autowired
    private ObjectFactory<Repo> repo;
    private Class<?> dtoType;
    public BaseService(){
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        dtoType = (Class<DTOResp>) paramType.getActualTypeArguments()[2];
    }

    public DTOResp findById(ID id){
        return (DTOResp) getRepo().findById(id).map(x -> getMapper().map(x,dtoType)).orElseThrow();
    }
    public void removeById(ID id){
        getRepo().deleteById(id);
    }
    public List<DTOResp> findAll(){
        return (List<DTOResp>) getRepo().findAll().stream().map(x -> getMapper().map(x,dtoType)).collect(Collectors.toList());
    }

    protected Repo getRepo(){
        return repo.getObject();
    }
    protected ModelMapper getMapper(){
        return new ModelMapper();
    }
}
