/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.Star;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StarSpawner
implements Runnable {
    private static Random rnd = new Random();
    public Thread spawn = new Thread(this);
    public List<Star> stars = new ArrayList<Star>();

    @Override
    public void run() {
        while (true) {
            int speed = rnd.nextInt(8);
            while (speed < 2) {
                speed = rnd.nextInt(8);
            }
            Star addStar = new Star(rnd.nextInt(588), -20, rnd.nextInt(4), speed);
            this.stars.add(addStar);
            addStar.tm.start();
            Iterator<Star> starsiterator = this.stars.iterator();
            while (starsiterator.hasNext()) {
                Star star = starsiterator.next();
                if (star.y <= 650) continue;
                starsiterator.remove();
            }
            try {
                Thread.sleep(rnd.nextInt(800));
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }
}

