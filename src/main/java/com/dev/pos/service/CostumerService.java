package com.dev.pos.service;

import com.dev.pos.dto.CostumerDTO;

import java.util.List;

public interface CostumerService {

    List<CostumerDTO> findAllNative();
    List<CostumerDTO> findAllJPQL();
    void insertCostumerNative(CostumerDTO costumerDTO);
    void insertCostumerJPQL(CostumerDTO costumerDTO);

}
