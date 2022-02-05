package com.judyprograms.temperthestorm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;


@Entity
@Table(name = "players")
public class Player extends User {

//    @Id
//    @Column(name = "user_id")
//    private Long id;

    @Column
    private Long totalPoints;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "level_id")
//    @JsonManagedReference
//    private Level level;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "avatar_id", nullable = false)
//    @JsonManagedReference
//    private Avatar avatar;

//    @OneToMany
//    private List<Slice> currentSlices = new ArrayList<>();

//    @OneToMany
//    private List<Slice> completedSlices = new ArrayList<>();

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference
//    private User user;


    //  GETTERS & SETTERS

    public Long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
