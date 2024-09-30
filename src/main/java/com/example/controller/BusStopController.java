package com.example.controller;

import com.example.entity.Bus;
import com.example.entity.BusStop;
import com.example.entity.Stop;
import com.example.repository.BusRepository;
import com.example.repository.BusStopRepository;
import com.example.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController{

    private StopRepository stopRepository;
    private BusRepository busRepository;
    private BusStopRepository busStopRepository;

    public BusStopController(StopRepository stopRepository, BusRepository busRepository, BusStopRepository busStopRepository) {
        this.stopRepository = stopRepository;
        this.busRepository = busRepository;
        this.busStopRepository = busStopRepository;
    }

    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(
            @RequestParam long busId,
            @RequestParam long stopId,
            @RequestBody BusStop busStop

    ){
        System.out.println(1);
//        Bus bus = busRepository.findById(busId).get();
        Bus bus = busRepository.findById(busId).get();
        System.out.println(2);
        System.out.println(busId);
        Stop stop = stopRepository.findById(stopId).get();
        System.out.println(3);
        System.out.println(stop);



        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop savedEntity = busStopRepository.save(busStop);
        System.out.println(11);


        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }
}
