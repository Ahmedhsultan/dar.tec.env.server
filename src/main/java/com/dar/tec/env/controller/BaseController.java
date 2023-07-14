package com.dar.tec.env.controller;

import com.dar.tec.env.service.BaseService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class BaseController <ID, Service extends BaseService, DTOResp>{
    @Autowired
    protected ObjectFactory<Service> service;

    @GetMapping("all")
    public ResponseEntity<List<DTOResp>> getAll(){
        return ResponseEntity.ok(getService().findAll());
    }
    @GetMapping
    public DTOResp getById(@RequestParam ID id){
        return (DTOResp) getService().findById(id);
    }
    @DeleteMapping
    public void deleteById(@RequestParam ID id){
        getService().removeById(id);
    }

    protected Service getService(){
        return service.getObject();
    }
}