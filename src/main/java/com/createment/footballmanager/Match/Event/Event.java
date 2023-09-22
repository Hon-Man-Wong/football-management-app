package com.createment.footballmanager.Match.Event;

import com.createment.footballmanager.Match.Match;
import com.createment.footballmanager.Player.Player;
import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer timeStamp;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Type type;
    @ManyToOne
    private Player player;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
