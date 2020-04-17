package com.zwb.service;

import com.zwb.entity.WaterVideo;
import com.zwb.dao.WaterVideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jackieonway
 * @version 1.0
 * @className WaterVideoService
 **/
@Repository
public class WaterVideoService {
    @Autowired
    public WaterVideoDao waterVideoDao;

    public void save(WaterVideo waterVideo){
        if(waterVideoDao == null){
            waterVideoDao.toString();
        }

    }

    public Page<WaterVideo> get(){
        return waterVideoDao.findAll(PageRequest.of(0,10,Sort.Direction.DESC,"clientAddress","waterCreate"));
    }
    public Page<WaterVideo> getAll(){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"clientAddress"));
        orders.add(new Sort.Order(Sort.Direction.ASC,"waterCreate"));
        return waterVideoDao.findAll(PageRequest.of(0,10,Sort.by(orders)));
    }


}
