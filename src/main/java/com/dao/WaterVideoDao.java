package com.dao;

import com.entity.WaterVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Jackieonway
 * @version 1.0
 * @interfaceName WaterVideoDao
 **/
@Repository
public interface WaterVideoDao extends JpaRepository<WaterVideo,Integer>,JpaSpecificationExecutor<WaterVideo>,Serializable {
}
