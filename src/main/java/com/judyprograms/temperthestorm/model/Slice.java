package com.judyprograms.temperthestorm.model;

import javax.persistence.ManyToOne;

public class Slice {

    public long id;
    public String name;
    public long points;

//    @ManyToOne
    public Subtask subtask;
}
