/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.BallMoving;
import com.spaceoid.KeyboardEvent;
import com.spaceoid.LevelPanel;
import com.spaceoid.Levels;
import com.spaceoid.Manager;
import com.spaceoid.PlanetSpawner;
import com.spaceoid.StarSpawner;
import com.spaceoid.Storage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Initializate {
    public static void init() {
        Storage.frame = new JFrame("Spaceoid 8bit v0.2");
        Storage.frame.setDefaultCloseOperation(3);
        Storage.frame.setResizable(false);
        Storage.frame.setSize(582, 640);
        Storage.frame.setLocationRelativeTo(null);
        try {
            Storage.BLUEPLATFORML = ImageIO.read(new File("res/BluePlatformL.png"));
            Storage.BLUEPLATFORMR = ImageIO.read(new File("res/BluePlatformR.png"));
            Storage.REDPLATFORML = ImageIO.read(new File("res/RedPlatformL.png"));
            Storage.REDPLATFORMR = ImageIO.read(new File("res/RedPlatformR.png"));
            Storage.PLATFORML = ImageIO.read(new File("res/PlatformL.png"));
            Storage.PLATFORMC = ImageIO.read(new File("res/PlatformC.png"));
            Storage.PLATFORMR = ImageIO.read(new File("res/PlatformR.png"));
            Storage.BALL = ImageIO.read(new File("res/Ball.png"));
            Storage.STARONE = ImageIO.read(new File("res/Star1.png"));
            Storage.STARTWO = ImageIO.read(new File("res/Star2.png"));
            Storage.STARTHREE = ImageIO.read(new File("res/Star3.png"));
            Storage.STARFOUR = ImageIO.read(new File("res/Star4.png"));
            Storage.PLANETONE = ImageIO.read(new File("res/Planet1.png"));
            Storage.PLANETTWO = ImageIO.read(new File("res/Planet2.png"));
            Storage.PLANETTHREE = ImageIO.read(new File("res/Planet3.png"));
            Storage.ZERO = ImageIO.read(new File("res/Letter0.png"));
            Storage.ONE = ImageIO.read(new File("res/Letter1.png"));
            Storage.TWO = ImageIO.read(new File("res/Letter2.png"));
            Storage.THREE = ImageIO.read(new File("res/Letter3.png"));
            Storage.FOUR = ImageIO.read(new File("res/Letter4.png"));
            Storage.FIVE = ImageIO.read(new File("res/Letter5.png"));
            Storage.SIX = ImageIO.read(new File("res/Letter6.png"));
            Storage.SEVEN = ImageIO.read(new File("res/Letter7.png"));
            Storage.EIGHT = ImageIO.read(new File("res/Letter8.png"));
            Storage.NINE = ImageIO.read(new File("res/Letter9.png"));
            Storage.A = ImageIO.read(new File("res/LetterA.png"));
            Storage.C = ImageIO.read(new File("res/LetterC.png"));
            Storage.E = ImageIO.read(new File("res/LetterE.png"));
            Storage.F = ImageIO.read(new File("res/LetterF.png"));
            Storage.I = ImageIO.read(new File("res/LetterI.png"));
            Storage.L = ImageIO.read(new File("res/LetterL.png"));
            Storage.O = ImageIO.read(new File("res/LetterO.png"));
            Storage.P = ImageIO.read(new File("res/LetterP.png"));
            Storage.R = ImageIO.read(new File("res/LetterR.png"));
            Storage.S = ImageIO.read(new File("res/LetterS.png"));
            Storage.T = ImageIO.read(new File("res/LetterT.png"));
            Storage.X = ImageIO.read(new File("res/LetterX.png"));
            Storage.Y = ImageIO.read(new File("res/LetterY.png"));
            Storage.DVOETOCHIE = ImageIO.read(new File("res/LetterDvoetochie.png"));
            Storage.ARROW = ImageIO.read(new File("res/LetterArrow.png"));
            Storage.numbers[0] = Storage.ZERO;
            Storage.numbers[1] = Storage.ONE;
            Storage.numbers[2] = Storage.TWO;
            Storage.numbers[3] = Storage.THREE;
            Storage.numbers[4] = Storage.FOUR;
            Storage.numbers[5] = Storage.FIVE;
            Storage.numbers[6] = Storage.SIX;
            Storage.numbers[7] = Storage.SEVEN;
            Storage.numbers[8] = Storage.EIGHT;
            Storage.numbers[9] = Storage.NINE;
        }
        catch (Exception exception) {
            // empty catch block
        }
        Storage.levelPanel = new LevelPanel();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 7; ++j) {
                Manager.level[j][i] = Levels.level1[j][i];
            }
        }
        Storage.frame.setContentPane(Storage.levelPanel);
        Storage.keyboardEvent = new KeyboardEvent();
        Storage.frame.addKeyListener(Storage.keyboardEvent);
        Storage.ballMoving = new BallMoving();
        Storage.starSpawner = new StarSpawner();
        Storage.planetSpawner = new PlanetSpawner();
        Storage.levelPanel.openMenu();
        Storage.starSpawner.spawn.start();
        Storage.planetSpawner.spawn.start();
        Storage.frame.setVisible(true);
    }
}

