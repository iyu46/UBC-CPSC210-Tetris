package model.pieces;

import logic.Board;
import model.Animatables;
import model.Square;

public class SPiece implements Animatables {

    private Square one;
    private Square two;
    private Square thr;
    private Square fou;

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("green", x + 1, y);
        Square two = new Square("green", x, y);
        Square thr = new Square("green", x, y + 1);
        Square fou = new Square("green", x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void update(){
        //TODO: fall, etc
    }
}