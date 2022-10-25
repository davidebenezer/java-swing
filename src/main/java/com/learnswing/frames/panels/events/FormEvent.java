package com.learnswing.frames.panels.events;


import lombok.Getter;

import java.util.EventObject;

@Getter
public class FormEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private String name;
    private String occupation;
    private int ageCategory;
    private int empCategory;
    private boolean isCitizen;
    private String taxDetails;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,
                     String name,
                     String occupation,
                     int ageCategory,
                     int empCategory,
                     boolean isCitizen,
                     String taxDetails,
                     String gender){
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.isCitizen = isCitizen;
        this.taxDetails = taxDetails;
        this.gender = gender;
    }
}
