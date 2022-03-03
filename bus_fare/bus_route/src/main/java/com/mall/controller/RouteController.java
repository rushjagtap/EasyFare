package com.mall.controller;

import com.mall.entry.BusRoute;
import com.mall.mapper.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;

    @GetMapping("/getAll")
    public List<BusRoute> queryStudent(){
        List<BusRoute> list ;
        list = routeRepository.findAll();
        return list  ;
    }
    @GetMapping("/getOne")
    public Optional<BusRoute> queryStudent(@RequestParam Integer id){
        Optional<BusRoute> busroute = routeRepository.findById(id);
        return busroute;
    }
    @GetMapping(value="/add", produces = {"application/json;charset=UTF-8"})
    public BusRoute addStudent(@RequestBody BusRoute route){
        BigDecimal distance=new BigDecimal(route.getDistance());
        route.setPrice(distance.multiply(new BigDecimal(0.5)));
        route= routeRepository.save(route);
        return route;
    }

    @GetMapping(value="/delete")
    public String delete(@RequestParam Integer id){
        routeRepository.deleteById(id);
        return "delete success";
    }

    @PostMapping(value="/calculatePrice", produces = {"application/json;charset=UTF-8"})
    public BigDecimal calculatePrice(@RequestParam Integer distance,@RequestParam Boolean ifTouristSeason,@RequestParam Boolean ifbadWeather){
        BigDecimal realdistance=new BigDecimal(distance);
        BigDecimal newPrice ;
        if(ifTouristSeason){
            newPrice =(realdistance.multiply(new BigDecimal(0.7))).setScale(2, BigDecimal.ROUND_HALF_UP);
        }else if(ifbadWeather){
            newPrice =(realdistance.multiply(new BigDecimal(0.6))).setScale(2, BigDecimal.ROUND_HALF_UP);
        }else{
            newPrice =(realdistance.multiply(new BigDecimal(0.5))).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
            return newPrice;
    }
}
