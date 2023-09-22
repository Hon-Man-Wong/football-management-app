package com.createment.footballmanager.Enumerations;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/enums")
public class EnumController {

    @GetMapping("/league")
    public League[] getAllLeagues(){
        return League.values();
    }

    @GetMapping("/country")
    public Country[] getAllCountries(){
        return Country.values();
    }
    @GetMapping("/position")
    public Position[] getAllPositions(){
        return Position.values();
    }
}
