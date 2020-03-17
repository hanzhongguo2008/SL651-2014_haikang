package com.service;

import com.dao.WaterVideoDao;
import com.entity.WaterVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
@Service
public class WaterVideoService {
    @Autowired
    private WaterVideoDao WaterVideoDao;

    public Page<WaterVideo> get(){
        return WaterVideoDao.findAll(PageRequest.of(0,10,Sort.Direction.DESC,"clientAddress","waterCreate"));
    }
    public Page<WaterVideo> getAll(){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"clientAddress"));
        orders.add(new Sort.Order(Sort.Direction.ASC,"waterCreate"));
        return WaterVideoDao.findAll(PageRequest.of(0,10,Sort.by(orders)));
    }

    public Page<WaterVideo> getAllPage(){
        Specification<WaterVideo> specification = new Specification<WaterVideo>() {
            @Override
            public Predicate toPredicate(Root<WaterVideo> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.like(root.get("clientAddress").as(String.class), "%12%");
                Predicate p2 = criteriaBuilder.like(root.get("password").as(String.class), "12%");
                Predicate p3 = criteriaBuilder.like(root.get("userName").as(String.class), "12%");
                criteriaQuery.where(criteriaBuilder.and(p1,criteriaBuilder.or(p2,p3))); //where p1 and ( p2 or p3);
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("userName").as(String.class)),
                        criteriaBuilder.desc(root.get("clientAddress").as(String.class))); // order by user_name asc,name desc
                return criteriaQuery.getRestriction();
            }
        };
        return WaterVideoDao.findAll(specification,PageRequest.of(0,10));
    }
}
