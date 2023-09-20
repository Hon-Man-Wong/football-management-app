package com.createment.footballmanager;

public enum Position {
    GK("Goalkeeper"),
    CB("Centre Back"),
    LB("Left_Back"),
    RB("Right Back"),
    RWB("Right Wing Back"),
    LWB("Left Wing Back"),
    CDM("Central Defensive Midfielder"),
    CM("Central Midfielder"),
    CAM("Central Attacking Midfielder"),
    LM("Left Midfielder"),
    RM("Right Midfielder"),
    LW("Left Winger"),
    RW("Right Winger"),
    CF("Central Forward"),
    ST("Striker")
    ;

    private String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
