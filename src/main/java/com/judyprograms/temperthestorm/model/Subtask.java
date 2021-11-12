package com.judyprograms.temperthestorm.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class Subtask {

    public long id;
    public String subtaskName;

    public Badge badge;

//    @ManyToOne
    public MainTask mainTask;

//    @OneToMany
//    public List<Slice> slices;
}
