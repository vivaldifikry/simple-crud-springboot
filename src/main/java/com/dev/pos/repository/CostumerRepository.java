package com.dev.pos.repository;

import com.dev.pos.entity.CostumerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CostumerRepository extends JpaRepository<CostumerEntity, Long> {

    @Query(value = "SELECT * FROM costumer", nativeQuery = true)
    List<CostumerEntity> findAllNative();

    @Query("SELECT p FROM CostumerEntity p")
    List<CostumerEntity> findAllJPQL();

    /*
    @Modifying
    @Query(value = "INSERT INTO costumer (costumername, costumeraddress) VALUES (:name, :address)", nativeQuery = true)
    @Transactional
    void insertCostumerNative(String name, String address);

    @Modifying
    @Query("INSERT INTO CostumerEntity c (c.name, c.address) VALUES (:name, :address)")
    @Transactional
    void insertCostumerJPQL(String name, String address);

     */

    @Modifying
    @Query(value = "INSERT INTO costumer (costumername, costumeraddress) VALUES (:name, :address)", nativeQuery = true)
    @Transactional
    void insertCostumerNative(String name, String address);

    @Modifying
    @Query("INSERT INTO CostumerEntity c (c.name, c.address) VALUES (:name, :address)")
    @Transactional
    void insertCostumerJPQL(String name, String address);
}
