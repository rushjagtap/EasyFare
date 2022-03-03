package com.mall.controller;

import com.mall.entry.RouteHistory;
import com.mall.mapper.RouteHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/routeHistory")
public class RouteHistoryController {

    @Autowired
    RouteHistoryRepository routeHistoryRepository;

    @RequestMapping("/getAll")
    public List<RouteHistory> queryStudent(){
        List<RouteHistory> list ;
        list = routeHistoryRepository.findAll();
        return list  ;
    }
    @RequestMapping("/getById")
    public Optional<RouteHistory> getById(@RequestParam Integer id){
        Optional<RouteHistory> busroute = routeHistoryRepository.findById(id);
        return busroute;
    }
    @RequestMapping(value="/add", produces = {"application/json;charset=UTF-8"})
    public RouteHistory addStudent(@RequestBody RouteHistory routeHistory){
        routeHistory= routeHistoryRepository.save(routeHistory);
        return routeHistory;
    }

    @RequestMapping(value="/delete")
    public String delete(@RequestParam Integer id){
        routeHistoryRepository.deleteById(id);
        return "delete success";
    }

    @RequestMapping(value="/getByUserId")
    public List<RouteHistory> getByUserId(@RequestParam Integer userId){
        RouteHistory routeHistory = new RouteHistory();
        routeHistory.setUserId(userId);
        Example<RouteHistory> example = Example.of(routeHistory);
        List<RouteHistory> list = routeHistoryRepository.findAll(example);
        return list;
    }
}
