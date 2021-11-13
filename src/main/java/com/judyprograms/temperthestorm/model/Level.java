package com.judyprograms.temperthestorm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Long id;

    @Column
    private int number;

    @Column
    private String name;

    @OneToMany(mappedBy = "level",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Player> players;

// /////// CONSTRUCTOR

    public Level (){
    }

    public Level(Long id, int number, String name, List<Player> players) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.players = players;
    }

// /////// GETTERS & SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
