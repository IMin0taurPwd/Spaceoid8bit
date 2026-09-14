/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.Planet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PlanetSpawner
implements Runnable {
    private static Random rnd = new Random();
    public Thread spawn = new Thread(this);
    public List<Planet> planets = new ArrayList<Planet>();

    @Override
    public void run() {
        while (true) {
            int speed = rnd.nextInt(4);
            while (speed < 1) {
                speed = rnd.nextInt(4);
            }
            Planet addPlanet = new Planet(rnd.nextInt(556), -270, rnd.nextInt(3), speed);
            this.planets.add(addPlanet);
            addPlanet.tm.start();
            Iterator<Planet> planetsiterator = this.planets.iterator();
            while (planetsiterator.hasNext()) {
                Planet planet = planetsiterator.next();
                if (planet.y <= 650) continue;
                planetsiterator.remove();
            }
            try {
                Thread.sleep(rnd.nextInt(20000));
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }
}

