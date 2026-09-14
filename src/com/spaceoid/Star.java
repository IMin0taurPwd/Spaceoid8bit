/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Star
implements ActionListener {
    public int x;
    public int y;
    public int size;
    public int speed;
    public Timer tm = new Timer(5, this);

    public Star(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.y += this.speed;
    }
}

