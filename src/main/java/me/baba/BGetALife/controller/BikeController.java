package me.baba.BGetALife.controller;

import me.baba.BGetALife.model.Bike;
import me.baba.BGetALife.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {

    @Autowired
    private BikeRepository bikeRepository;

    @RequestMapping("/bikes")
    public Iterable<Bike> getBikes() {
        return bikeRepository.findAll();
    }
}
