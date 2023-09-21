package com.createment.footballmanager.Player;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PlayerService {

    public int getAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        return age.getYears();
    }
}
