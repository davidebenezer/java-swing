package com.learnswing.frames.panels.events;

import com.learnswing.frames.panels.FormPanel;
import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

@Getter
@Setter
public class FormEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private String name;
    private String occupation;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation){
        super(source);
        this.name = name;
        this.occupation = occupation;
    }
}
