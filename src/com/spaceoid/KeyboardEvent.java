/*
 * Decompiled with CFR 0.152.
 */
package com.spaceoid;

import com.spaceoid.Manager;
import com.spaceoid.Storage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class KeyboardEvent
implements KeyListener,
ActionListener {
    public boolean RightPressed = false;
    public boolean LeftPressed = false;
    public boolean SpacePressed = false;
    public boolean UpTyped = false;
    public boolean DownTyped = false;
    public boolean EnterTyped = false;
    public boolean menuUsed = false;
    private Timer tm = new Timer(5, this);

    public KeyboardEvent() {
        this.tm.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65: {
                this.LeftPressed = true;
                break;
            }
            case 37: {
                this.LeftPressed = true;
                break;
            }
            case 68: {
                this.RightPressed = true;
                break;
            }
            case 39: {
                this.RightPressed = true;
                break;
            }
            case 10: {
                if (!this.menuUsed) {
                    this.menuUsed = true;
                    this.EnterTyped = true;
                }
                this.SpacePressed = true;
                break;
            }
            case 38: {
                if (!this.menuUsed) {
                    this.menuUsed = true;
                    this.UpTyped = true;
                }
                this.SpacePressed = true;
                break;
            }
            case 87: {
                this.SpacePressed = true;
                break;
            }
            case 40: {
                if (this.menuUsed) break;
                this.menuUsed = true;
                this.DownTyped = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65: {
                this.LeftPressed = false;
                break;
            }
            case 37: {
                this.LeftPressed = false;
                break;
            }
            case 68: {
                this.RightPressed = false;
                break;
            }
            case 39: {
                this.RightPressed = false;
                break;
            }
            case 10: {
                if (this.menuUsed) {
                    this.menuUsed = false;
                    this.EnterTyped = false;
                }
                this.SpacePressed = false;
                break;
            }
            case 38: {
                if (this.menuUsed) {
                    this.menuUsed = false;
                    this.UpTyped = false;
                }
                this.SpacePressed = false;
                break;
            }
            case 87: {
                this.SpacePressed = false;
                break;
            }
            case 40: {
                if (!this.menuUsed) break;
                this.menuUsed = false;
                this.DownTyped = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Storage.levelPanel.layer.equals("level")) {
            if (this.RightPressed) {
                Manager.xpl += 3;
            }
            if (this.LeftPressed) {
                Manager.xpl -= 3;
            }
            if (Manager.xpl < 0) {
                Manager.xpl += 3;
            } else if (Manager.xpl + 32 + 32 + 32 + 6 > 582) {
                Manager.xpl -= 3;
            }
            if (this.SpacePressed) {
                Manager.ballStarted = true;
            }
        } else if (Storage.levelPanel.layer.equals("menu")) {
            if (this.UpTyped) {
                this.UpTyped = false;
                --Storage.levelPanel.menuSelected;
                if (Storage.levelPanel.menuSelected < 0) {
                    Storage.levelPanel.menuSelected = 0;
                }
            }
            if (this.DownTyped) {
                this.DownTyped = false;
                ++Storage.levelPanel.menuSelected;
                if (Storage.levelPanel.menuSelected > 1) {
                    Storage.levelPanel.menuSelected = 1;
                }
            }
            if (this.EnterTyped) {
                switch (Storage.levelPanel.menuSelected) {
                    case 0: {
                        Storage.levelPanel.openGame();
                        break;
                    }
                    case 1: {
                        System.exit(0);
                    }
                }
                this.UpTyped = false;
            }
        }
    }
}

