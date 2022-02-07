package com.judyprograms.temperthestorm.model;

import javax.persistence.*;

@Entity
@Table(name = "slices")
public class Slice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Long sliceNumber;

    @Column
    private String sliceText;

//    @ManyToOne
//    public Subtask subtask;


    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSliceNumber() {
        return sliceNumber;
    }

    public void setSliceNumber(Long sliceNumber) {
        this.sliceNumber = sliceNumber;
    }

    public String getSliceText() {
        return sliceText;
    }

    public void setSliceText(String sliceText) {
        this.sliceText = sliceText;
    }

}
