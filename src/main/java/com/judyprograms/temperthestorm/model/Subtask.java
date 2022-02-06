package com.judyprograms.temperthestorm.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class Subtask {

    public long id;
    public String subtaskName;

//    @ManyToOne
    public MainTask mainTask;

//    @OneToMany
//    public List<Slice> slices;


    // /////// GETTERS & SETTERS

}
