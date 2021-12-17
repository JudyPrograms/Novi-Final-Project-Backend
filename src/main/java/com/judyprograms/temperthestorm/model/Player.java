package com.judyprograms.temperthestorm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Column
    private Long totalPoints;

//    KLOPT NOG NIET: dit moet een object met 4 private double counts worden,
//    nl voor iedere MainTask
    @Column
    private double subtaskCount;

    @Column
    private Long levelNumber;

    @Column
    private String avatarName;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "level_id")
//    @JsonManagedReference
//    private Level level;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "avatar_id", nullable = false)
    @JsonManagedReference
    private Avatar avatar;

//    @OneToMany
//    private List<Slice> currentSlices = new ArrayList<>();

//    @OneToMany
//    private List<Slice> completedSlices = new ArrayList<>();

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;


// /////// CONSTRUCTORS

//    Dit is niet handig in de klasse, maar beter in de service laag van de User:
//    public Player(Long id, Long totalPoints, double subtaskCount, Long levelNumber, String avatarName, User user) {
//        this.id = id;
//        this.totalPoints = totalPoints;
//        this.subtaskCount = subtaskCount;
//        this.levelNumber = levelNumber;
//        this.avatarName = avatarName;
//        this.user = user;
//    }
//
//    public Player(Long id, User user) {
//        this(id, 0L, 0, 1L, "Warrior", user);
//    }


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

    public double getSubtaskCount() {
        return subtaskCount;
    }

    public void setSubtaskCount(double subtaskCount) {
        this.subtaskCount = subtaskCount;
    }

    public Long getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Long levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
