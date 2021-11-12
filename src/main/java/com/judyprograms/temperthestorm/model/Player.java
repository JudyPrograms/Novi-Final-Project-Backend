package com.judyprograms.temperthestorm.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "players")
public class Player extends User{

    private long totalPoints;

    private Avatar avatar;
    private Level level;

//    @OneToMany
//    private List<Badge> badges;

//    @OneToMany
//    private List<Slice> currentSlices = new ArrayList<>();
//    private List<Slice> completedSlices = new ArrayList<>();


}
