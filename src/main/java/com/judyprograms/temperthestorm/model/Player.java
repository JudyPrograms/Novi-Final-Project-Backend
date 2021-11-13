package com.judyprograms.temperthestorm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "user_id")
    private Long id;


    @Column
    private Long totalPoints;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "level_id")
    @JsonManagedReference
    private Level level;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "avatar_id", nullable = false)
//    @JsonManagedReference
//    private Avatar avatar;


//    @OneToMany
//    private List<Slice> currentSlices = new ArrayList<>();

//    @OneToMany
//    private List<Slice> completedSlices = new ArrayList<>();

//    KLOPT NOG NIET: dit moet een object met 4 private double counts worden,
//    nl voor iedere MainTask
    @Column
    private double subtaskCount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

// /////// CONSTRUCTOR

    public Player() {
    }

    public Player(Long id, Long totalPoints, Level level, double subtaskCount, User user) {
        this.id = id;
        this.totalPoints = totalPoints;
        this.level = level;
        this.subtaskCount = subtaskCount;
        this.user = user;
    }

// /////// GETTERS & SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

//    public Avatar getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(Avatar avatar) {
//        this.avatar = avatar;
//    }

//    public List<Slice> getCurrentSlices() {
//        return currentSlices;
//    }
//
//    public void setCurrentSlices(List<Slice> currentSlices) {
//        this.currentSlices = currentSlices;
//    }
//
//    public List<Slice> getCompletedSlices() {
//        return completedSlices;
//    }
//
//    public void setCompletedSlices(List<Slice> completedSlices) {
//        this.completedSlices = completedSlices;
//    }

    public double getSubtaskCount() {
        return subtaskCount;
    }

    public void setSubtaskCount(double subtaskCount) {
        this.subtaskCount = subtaskCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
