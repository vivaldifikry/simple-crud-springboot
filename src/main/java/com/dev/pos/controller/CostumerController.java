package com.dev.pos.controller;

import com.dev.pos.dto.CostumerDTO;
import com.dev.pos.dto.ProductDTO;
import com.dev.pos.service.CostumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    private final CostumerService costumerService;

    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping("/native")
    public List<CostumerDTO> findAllProductsNative(){
        return costumerService.findAllNative();
    }

    @GetMapping("/jpql")
    public List<CostumerDTO> findAllProductsJPQL(){
        return costumerService.findAllJPQL();
    }

    @PostMapping("/native/insert")
    public void insertCostumerNative(@RequestBody CostumerDTO costumerDTO) {
        costumerService.insertCostumerNative(costumerDTO);
    }

    @PostMapping("/jpql/insert")
    public void insertCostumerJPQL(@RequestBody CostumerDTO costumerDTO) {
        costumerService.insertCostumerJPQL(costumerDTO);
    }

}
