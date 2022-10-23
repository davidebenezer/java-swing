package com.learnswing.listener;

import com.learnswing.frames.panels.events.FormEvent;

import java.util.EventListener;

public interface FormListener extends EventListener {
    void formEventOccurred(FormEvent e);
}
