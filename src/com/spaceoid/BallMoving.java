/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.Manager;
import com.spaceoid.Storage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class BallMoving
implements ActionListener,
Runnable {
    public Timer tm = new Timer(5, this);
    public Thread th;
    private Random rnd = new Random();
    boolean isCollision = false;
    boolean canCollisionPlatform = true;

    public BallMoving() {
        this.tm.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Manager.ballStarted) {
            Manager.xball = Manager.xpl + 48 - 16;
            Manager.yball = 544.0;
        } else {
            if (Manager.sxball == 0.0) {
                boolean random = this.rnd.nextBoolean();
                Manager.sxball = random ? 2.0 : -2.0;
            }
            Manager.xball += Manager.sxball;
            Manager.yball += Manager.syball;
            if (Manager.xball < 0.0) {
                Manager.sxball = -Manager.sxball;
                Manager.xball += 3.0;
            }
            if (Manager.xball + 32.0 + 6.0 > 582.0) {
                Manager.sxball = -Manager.sxball;
                Manager.xball -= 3.0;
            }
            if (Manager.yball < 0.0) {
                Manager.syball = -Manager.syball;
                Manager.yball += 3.0;
            }
            if (Manager.yball > 704.0) {
                Manager.ballStarted = false;
                Manager.sxball = 0.0;
                Manager.syball = -2.8;
                Manager.xpl = 243;
                --Storage.levelPanel.lifes;
                if (Storage.levelPanel.lifes < 0) {
                    Storage.levelPanel.gameOver();
                }
            }
            if (Manager.xball + 32.0 > (double)Manager.xpl && Manager.xball < (double)(Manager.xpl + 32 + 32 + 32) && Manager.yball + 32.0 > 576.0 && Manager.yball < 592.0 && this.canCollisionPlatform) {
                this.th = new Thread(this);
                this.th.start();
                Manager.sxball = Manager.xball + 16.0 > (double)(Manager.xpl + 32 + 32 + 16) ? 4.0 : (Manager.xball + 16.0 > (double)(Manager.xpl + 32 - 16) ? (Manager.sxball > 0.0 ? 2.0 : -2.0) : -4.0);
                Manager.syball = -Manager.syball;
                Storage.levelPanel.score += 10L;
            }
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 7; ++j) {
                    if (Manager.level[j][i] <= 0) continue;
                    double x = Manager.xball;
                    double y = Manager.yball;
                    int wx = i * 64;
                    int wy = j * 32;
                    if (!(x + 32.0 > (double)wx) || !(x < (double)(wx + 64)) || !(y + 32.0 > (double)wy) || !(y < (double)(wy + 32))) continue;
                    if (!this.isCollision) {
                        double sxballrnd = Math.random() * 5.0;
                        while (sxballrnd < 2.0) {
                            sxballrnd = Math.random() * 5.0;
                        }
                        Manager.sxball = Manager.sxball > 0.0 ? -sxballrnd : sxballrnd;
                        Storage.levelPanel.score += 100L;
                        Manager.syball = -Manager.syball;
                    }
                    Manager.level[j][i] = 0;
                    this.isCollision = true;
                }
            }
            this.isCollision = false;
            boolean isEndLevel = true;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 7; ++j) {
                    if (Manager.level[j][i] <= 0) continue;
                    isEndLevel = false;
                }
            }
            if (isEndLevel) {
                Storage.levelPanel.nextLevel();
            }
        }
    }

    @Override
    public void run() {
        this.canCollisionPlatform = false;
        try {
            Thread.sleep(300L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.canCollisionPlatform = true;
    }
}

