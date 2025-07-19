package org.ishim.checkers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class  CheckerBoardState {

//    public static class CheckerBoardStateSingleton {

    private static CheckerBoardState CHECKERBOARDSTATE;

    public static CheckerBoardState getInstance() {
        return Objects.isNull(CHECKERBOARDSTATE) ? new CheckerBoardState() : CHECKERBOARDSTATE;
    }

//    }

    private final static int DEFAULT_SIZE = 10;

    private int size;
    private HashSet<PieceState> boardSet;
    private Player currentPlayer;

    private CheckerBoardState() {
        size = DEFAULT_SIZE;
        boardSet = new HashSet<>();
    }

    public CheckerBoardState(HashSet<PieceState> boardSet, int size) {
        this.boardSet = boardSet;
        this.size = size;
    }

    public HashSet<PieceState> getBoardSet() {
        return boardSet;
    }

    public void setBoardSet(HashSet<PieceState> boardSet) {
        this.boardSet = boardSet;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    public Map.Entry<Integer, Integer> getPosition() {
//
//    }
}
