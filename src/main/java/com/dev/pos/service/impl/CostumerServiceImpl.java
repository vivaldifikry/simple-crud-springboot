package com.dev.pos.service.impl;

import com.dev.pos.dto.CostumerDTO;
import com.dev.pos.entity.CostumerEntity;
import com.dev.pos.repository.CostumerRepository;
import com.dev.pos.service.CostumerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostumerServiceImpl implements CostumerService {

    private final CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository){
        this.costumerRepository = costumerRepository;
    }

    @Override
    public List<CostumerDTO> findAllNative() {
        List<CostumerEntity> entities = costumerRepository.findAllNative();
        List<CostumerDTO> dtos = new ArrayList<>();

        for (CostumerEntity entity : entities) {
            CostumerDTO dto = convertToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<CostumerDTO> findAllJPQL() {
        List<CostumerEntity> entities = costumerRepository.findAllJPQL();
        List<CostumerDTO> dtos = new ArrayList<>();

        for (CostumerEntity entity : entities) {
            CostumerDTO dto = convertToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void insertCostumerNative(CostumerDTO costumerDTO) {
        CostumerEntity entity = convertToEntity(costumerDTO);
        costumerRepository.insertCostumerNative(entity.getName(), entity.getAddress());
    }

    @Override
    public void insertCostumerJPQL(CostumerDTO costumerDTO) {
        CostumerEntity entity = convertToEntity(costumerDTO);
        costumerRepository.insertCostumerJPQL(entity.getName(), entity.getAddress());
    }


    private CostumerDTO convertToDTO(CostumerEntity entity) {
        return new CostumerDTO(
                entity.getId(),
                entity.getName(),
                entity.getAddress()
        );
    }

    private CostumerEntity convertToEntity(CostumerDTO dto) {
        CostumerEntity entity = new CostumerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        return entity;
    }


}
