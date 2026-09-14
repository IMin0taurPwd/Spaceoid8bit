/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Planet
implements ActionListener {
    public int x;
    public int y;
    public int number;
    public int speed;
    public Timer tm = new Timer(30, this);

    public Planet(int x, int y, int number, int speed) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.speed = speed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.y += this.speed;
    }
}

