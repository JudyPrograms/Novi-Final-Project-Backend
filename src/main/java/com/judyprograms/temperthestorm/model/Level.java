package com.judyprograms.temperthestorm.model;

import javax.persistence.*;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "level_id")
    private Long id;

    @Column
    private Long levelNumber;

    @Column
    private String name;

//    @OneToMany(mappedBy = "level",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JsonBackReference
//    @JsonIgnore
//    private List<Player> players;


// /////// GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Long levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
