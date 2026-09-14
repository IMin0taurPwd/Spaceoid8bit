/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.Levels;
import com.spaceoid.Manager;
import com.spaceoid.Planet;
import com.spaceoid.Star;
import com.spaceoid.Storage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LevelPanel
extends JPanel
implements ActionListener {
    public Timer repainter = new Timer(1, this);
    public int lifes = 2;
    public long score = 0L;
    public int level = 1;
    public String layer = "";
    public int menuSelected = 0;
    public String wallWord = "";
    public String switchLayer = "";
    private boolean sleepRepaint = false;
    private boolean isRepainted = false;

    public LevelPanel() {
        this.repainter.start();
    }

    @Override
    public void paint(Graphics g) {
        block99: {
            block108: {
                block107: {
                    block98: {
                        char[] scoreToArray;
                        block106: {
                            block105: {
                                block104: {
                                    block103: {
                                        block102: {
                                            block101: {
                                                block100: {
                                                    if (!this.layer.equals("level")) break block98;
                                                    g.setColor(Color.BLACK);
                                                    g.fillRect(0, 0, 582, 640);
                                                    try {
                                                        for (Planet planet : Storage.planetSpawner.planets) {
                                                            switch (planet.number) {
                                                                case 0: {
                                                                    if (planet.speed == 3) {
                                                                        g.drawImage(Storage.PLANETONE, planet.x, planet.y, 256, 257, null);
                                                                        break;
                                                                    }
                                                                    if (planet.speed == 2) {
                                                                        g.drawImage(Storage.PLANETONE, planet.x, planet.y, 128, 128, null);
                                                                        break;
                                                                    }
                                                                    g.drawImage(Storage.PLANETONE, planet.x, planet.y, 64, 64, null);
                                                                    break;
                                                                }
                                                                case 1: {
                                                                    if (planet.speed == 3) {
                                                                        g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 256, 256, null);
                                                                        break;
                                                                    }
                                                                    if (planet.speed == 2) {
                                                                        g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 128, 128, null);
                                                                        break;
                                                                    }
                                                                    g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 64, 64, null);
                                                                    break;
                                                                }
                                                                case 2: {
                                                                    if (planet.speed == 3) {
                                                                        g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 256, 256, null);
                                                                        break;
                                                                    }
                                                                    if (planet.speed == 2) {
                                                                        g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 128, 128, null);
                                                                        break;
                                                                    }
                                                                    g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 64, 64, null);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    catch (Exception planetsiterator) {
                                                        // empty catch block
                                                    }
                                                    try {
                                                        for (Star star : Storage.starSpawner.stars) {
                                                            switch (star.size) {
                                                                case 0: {
                                                                    g.drawImage(Storage.STARONE, star.x, star.y, 32, 32, null);
                                                                    break;
                                                                }
                                                                case 1: {
                                                                    g.drawImage(Storage.STARTWO, star.x, star.y, 32, 32, null);
                                                                    break;
                                                                }
                                                                case 2: {
                                                                    g.drawImage(Storage.STARTHREE, star.x, star.y, 32, 32, null);
                                                                    break;
                                                                }
                                                                case 3: {
                                                                    g.drawImage(Storage.STARFOUR, star.x, star.y, 32, 32, null);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    catch (Exception starsiterator) {
                                                        // empty catch block
                                                    }
                                                    for (int i = 0; i < 9; ++i) {
                                                        for (int j = 0; j < 7; ++j) {
                                                            if (Manager.level[j][i] == 1) {
                                                                g.drawImage(Storage.BLUEPLATFORML, i * 64, j * 32, 32, 32, null);
                                                                g.drawImage(Storage.BLUEPLATFORMR, i * 64 + 32, j * 32, 32, 32, null);
                                                                continue;
                                                            }
                                                            if (Manager.level[j][i] != 2) continue;
                                                            g.drawImage(Storage.REDPLATFORML, i * 64, j * 32, 32, 32, null);
                                                            g.drawImage(Storage.REDPLATFORMR, i * 64 + 32, j * 32, 32, 32, null);
                                                        }
                                                    }
                                                    g.drawImage(Storage.PLATFORML, Manager.xpl, 576, 32, 32, null);
                                                    g.drawImage(Storage.PLATFORMC, Manager.xpl + 32, 576, 32, 32, null);
                                                    g.drawImage(Storage.PLATFORMR, Manager.xpl + 32 + 32, 576, 32, 32, null);
                                                    g.drawImage(Storage.BALL, (int)Manager.xball, (int)Manager.yball, 32, 32, null);
                                                    g.drawImage(Storage.L, 480, 5, 16, 16, null);
                                                    g.drawImage(Storage.I, 496, 5, null);
                                                    g.drawImage(Storage.F, 512, 5, null);
                                                    g.drawImage(Storage.E, 528, 5, null);
                                                    g.drawImage(Storage.DVOETOCHIE, 544, 5, null);
                                                    g.drawImage(Storage.numbers[this.lifes], 560, 5, null);
                                                    scoreToArray = String.valueOf(this.score).toCharArray();
                                                    g.drawImage(Storage.S, 5, 5, null);
                                                    g.drawImage(Storage.C, 21, 5, null);
                                                    g.drawImage(Storage.O, 37, 5, null);
                                                    g.drawImage(Storage.R, 53, 5, null);
                                                    g.drawImage(Storage.E, 69, 5, null);
                                                    g.drawImage(Storage.DVOETOCHIE, 85, 5, null);
                                                    if (this.score < 0L) break block99;
                                                    if (scoreToArray.length != 1) break block100;
                                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                                    break block99;
                                                }
                                                if (scoreToArray.length != 2) break block101;
                                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                                                break block99;
                                            }
                                            if (scoreToArray.length != 3) break block102;
                                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                                            break block99;
                                        }
                                        if (scoreToArray.length != 4) break block103;
                                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[3]))], 149, 5, null);
                                        break block99;
                                    }
                                    if (scoreToArray.length != 5) break block104;
                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[3]))], 149, 5, null);
                                    g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[4]))], 165, 5, null);
                                    break block99;
                                }
                                if (scoreToArray.length != 6) break block105;
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[3]))], 149, 5, null);
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[4]))], 165, 5, null);
                                g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[5]))], 181, 5, null);
                                break block99;
                            }
                            if (scoreToArray.length != 7) break block106;
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[3]))], 149, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[4]))], 165, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[5]))], 181, 5, null);
                            g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[6]))], 197, 5, null);
                            break block99;
                        }
                        if (scoreToArray.length != 8) break block99;
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[0]))], 101, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[1]))], 117, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[2]))], 133, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[3]))], 149, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[4]))], 165, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[5]))], 181, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[6]))], 197, 5, null);
                        g.drawImage(Storage.numbers[Integer.parseInt(String.valueOf(scoreToArray[7]))], 213, 5, null);
                        break block99;
                    }
                    if (!this.layer.equals("menu")) break block107;
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, 582, 640);
                    try {
                        for (Star star : Storage.starSpawner.stars) {
                            switch (star.size) {
                                case 0: {
                                    g.drawImage(Storage.STARONE, star.x, star.y, 32, 32, null);
                                    break;
                                }
                                case 1: {
                                    g.drawImage(Storage.STARTWO, star.x, star.y, 32, 32, null);
                                    break;
                                }
                                case 2: {
                                    g.drawImage(Storage.STARTHREE, star.x, star.y, 32, 32, null);
                                    break;
                                }
                                case 3: {
                                    g.drawImage(Storage.STARFOUR, star.x, star.y, 32, 32, null);
                                }
                            }
                        }
                    }
                    catch (Exception starsiterator) {
                        // empty catch block
                    }
                    g.drawImage(Storage.P, 227, 304, 32, 32, null);
                    g.drawImage(Storage.L, 259, 304, 32, 32, null);
                    g.drawImage(Storage.A, 291, 304, 32, 32, null);
                    g.drawImage(Storage.Y, 323, 304, 32, 32, null);
                    g.drawImage(Storage.E, 227, 336, 32, 32, null);
                    g.drawImage(Storage.X, 259, 336, 32, 32, null);
                    g.drawImage(Storage.I, 291, 336, 32, 32, null);
                    g.drawImage(Storage.T, 323, 336, 32, 32, null);
                    g.drawImage(Storage.ARROW, 195, 304 + this.menuSelected * 32, 32, 32, null);
                    break block99;
                }
                if (!this.layer.equals("wall")) break block108;
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, 614, 672);
                char[] wordArray = this.wallWord.toCharArray();
                for (int i = wordArray.length - 1; i > -1; --i) {
                    switch (wordArray[i]) {
                        case 'a': {
                            g.drawImage(Storage.A, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'b': {
                            g.drawImage(Storage.B, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'c': {
                            g.drawImage(Storage.C, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'd': {
                            g.drawImage(Storage.D, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'e': {
                            g.drawImage(Storage.E, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'f': {
                            g.drawImage(Storage.F, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'g': {
                            g.drawImage(Storage.G, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'h': {
                            g.drawImage(Storage.H, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'i': {
                            g.drawImage(Storage.I, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'j': {
                            g.drawImage(Storage.J, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'k': {
                            g.drawImage(Storage.K, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'l': {
                            g.drawImage(Storage.L, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'm': {
                            g.drawImage(Storage.M, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'n': {
                            g.drawImage(Storage.N, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'o': {
                            g.drawImage(Storage.O, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'p': {
                            g.drawImage(Storage.P, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'q': {
                            g.drawImage(Storage.Q, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'r': {
                            g.drawImage(Storage.R, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 's': {
                            g.drawImage(Storage.S, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 't': {
                            g.drawImage(Storage.T, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'u': {
                            g.drawImage(Storage.U, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'v': {
                            g.drawImage(Storage.V, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'w': {
                            g.drawImage(Storage.W, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'x': {
                            g.drawImage(Storage.X, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'y': {
                            g.drawImage(Storage.Y, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case 'z': {
                            g.drawImage(Storage.Z, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case ':': {
                            g.drawImage(Storage.DVOETOCHIE, 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '0': {
                            g.drawImage(Storage.numbers[0], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '1': {
                            g.drawImage(Storage.numbers[1], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '2': {
                            g.drawImage(Storage.numbers[2], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '3': {
                            g.drawImage(Storage.numbers[3], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '4': {
                            g.drawImage(Storage.numbers[4], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '5': {
                            g.drawImage(Storage.numbers[5], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '6': {
                            g.drawImage(Storage.numbers[6], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '7': {
                            g.drawImage(Storage.numbers[7], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '8': {
                            g.drawImage(Storage.numbers[8], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                            break;
                        }
                        case '9': {
                            g.drawImage(Storage.numbers[9], 291 - wordArray.length * 32 / 2 + 32 * i, 304, 32, 32, null);
                        }
                    }
                    if (!this.sleepRepaint) continue;
                    this.isRepainted = true;
                    this.sleepRepaint = false;
                }
                break block99;
            }
            if (!this.layer.equals("multiplayer")) break block99;
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 582, 640);
            try {
                for (Planet planet : Storage.planetSpawner.planets) {
                    switch (planet.number) {
                        case 0: {
                            if (planet.speed == 3) {
                                g.drawImage(Storage.PLANETONE, planet.x, planet.y, 256, 257, null);
                                break;
                            }
                            if (planet.speed == 2) {
                                g.drawImage(Storage.PLANETONE, planet.x, planet.y, 128, 128, null);
                                break;
                            }
                            g.drawImage(Storage.PLANETONE, planet.x, planet.y, 64, 64, null);
                            break;
                        }
                        case 1: {
                            if (planet.speed == 3) {
                                g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 256, 256, null);
                                break;
                            }
                            if (planet.speed == 2) {
                                g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 128, 128, null);
                                break;
                            }
                            g.drawImage(Storage.PLANETTWO, planet.x, planet.y, 64, 64, null);
                            break;
                        }
                        case 2: {
                            if (planet.speed == 3) {
                                g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 256, 256, null);
                                break;
                            }
                            if (planet.speed == 2) {
                                g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 128, 128, null);
                                break;
                            }
                            g.drawImage(Storage.PLANETTHREE, planet.x, planet.y, 64, 64, null);
                        }
                    }
                }
            }
            catch (Exception planetsiterator) {
                // empty catch block
            }
            try {
                for (Star star : Storage.starSpawner.stars) {
                    switch (star.size) {
                        case 0: {
                            g.drawImage(Storage.STARONE, star.x, star.y, 32, 32, null);
                            break;
                        }
                        case 1: {
                            g.drawImage(Storage.STARTWO, star.x, star.y, 32, 32, null);
                            break;
                        }
                        case 2: {
                            g.drawImage(Storage.STARTHREE, star.x, star.y, 32, 32, null);
                            break;
                        }
                        case 3: {
                            g.drawImage(Storage.STARFOUR, star.x, star.y, 32, 32, null);
                        }
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void gameOver() {
        this.lifes = 2;
        this.score = 0L;
        this.level = 1;
        Storage.levelPanel.closeWall("gameover", "menu");
        this.menuSelected = 0;
        Manager.ballStarted = false;
        Manager.sxball = 0.0;
        Manager.syball = -2.8;
        Manager.xpl = 243;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 7; ++j) {
                Manager.level[j][i] = Levels.level1[j][i];
            }
        }
    }

    public void nextLevel() {
        int levelMapNumber;
        ++this.level;
        Manager.ballStarted = false;
        Manager.sxball = 0.0;
        Manager.syball = -2.8;
        Manager.xpl = 243;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 7; ++j) {
                Manager.level[j][i] = Levels.level1[j][i];
            }
        }
        Storage.levelPanel.score += 1000L;
        for (levelMapNumber = this.level; levelMapNumber > 10; levelMapNumber -= 10) {
        }
        switch (levelMapNumber) {
            case 1: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level1[j][i];
                    }
                }
                break;
            }
            case 2: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level2[j][i];
                    }
                }
                break;
            }
            case 3: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level3[j][i];
                    }
                }
                break;
            }
            case 4: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level4[j][i];
                    }
                }
                break;
            }
            case 5: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level5[j][i];
                    }
                }
                break;
            }
            case 6: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level6[j][i];
                    }
                }
                break;
            }
            case 7: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level7[j][i];
                    }
                }
                break;
            }
            case 8: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level8[j][i];
                    }
                }
                break;
            }
            case 9: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level9[j][i];
                    }
                }
                break;
            }
            case 10: {
                int i;
                for (i = 0; i < 9; ++i) {
                    for (int j = 0; j < 7; ++j) {
                        Manager.level[j][i] = Levels.level10[j][i];
                    }
                }
                break;
            }
        }
        this.closeWall("level:" + this.level, "level");
    }

    public void openMultiplayer() {
    }

    public void openMenu() {
        this.layer = "menu";
        this.menuSelected = 0;
        Storage.planetSpawner.planets.clear();
        Storage.starSpawner.stars.clear();
        Manager.ballStarted = false;
        Manager.sxball = 0.0;
        Manager.syball = -2.8;
        Manager.xpl = 243;
    }

    public void openGame() {
        this.lifes = 2;
        this.menuSelected = 0;
        Manager.ballStarted = false;
        Manager.sxball = 0.0;
        Manager.syball = -2.8;
        Manager.xpl = 243;
        this.closeWall("level:" + this.level, "level");
    }

    public void closeWall(String word, String layer) {
        this.layer = "wall";
        this.switchLayer = layer;
        this.wallWord = word;
        this.sleepRepaint = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isRepainted) {
            try {
                Thread.sleep(3000L);
                Storage.keyboardEvent.SpacePressed = false;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            this.isRepainted = false;
            this.layer = this.switchLayer.toString();
            this.wallWord = "";
            Storage.planetSpawner.planets.clear();
            Storage.starSpawner.stars.clear();
        }
        this.repaint();
    }
}

