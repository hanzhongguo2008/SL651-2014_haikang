package com.zwb.dao;

import com.zwb.entity.WaterVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Jackieonway
 * @version 1.0
 * @interfaceName WaterVideoDao
 **/
public interface WaterVideoDao extends JpaRepository<WaterVideo,Integer> {

}
