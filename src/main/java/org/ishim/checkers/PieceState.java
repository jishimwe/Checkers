package org.ishim.checkers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PieceState {

    private int hPos;
    private int vPos;
    private Circle circle;
    private boolean isAlive;
    private boolean isQueen;
    private Player player;

    public PieceState(Circle circle, int hPos, int vPos, boolean isAlive, boolean isQueen) {
        this.circle = circle;
        this.hPos = hPos;
        this.isAlive = isAlive;
        this.isQueen = isQueen;
        this.vPos = vPos;
    }

    public PieceState(Circle circle, int hPos, int vPos, Player player) {
        this.circle = circle;
        this.hPos = hPos;
        this.vPos = vPos;
        this.player = player;
    }

    public PieceState() {
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public int gethPos() {
        return hPos;
    }

    public void sethPos(int hPos) {
        this.hPos = hPos;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isQueen() {
        return isQueen;
    }

    public void setQueen(boolean queen) {
        isQueen = queen;
    }

    public int getvPos() {
        return vPos;
    }

    public void setvPos(int vPos) {
        this.vPos = vPos;
    }
}
