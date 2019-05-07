package com.quadzillion.core;

import com.quadzillion.core.levels.ExtendedLevel;
import com.quadzillion.core.levels.Level;
import com.quadzillion.core.models.Constants;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.PuzzleMainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.*;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.util.ArrayList;

import static com.quadzillion.core.PuzzleGamePane.moveCounter;

public class ExtendedGamePane extends Pane {


    /* public  int moveCounter = 0;
    public  Label counter;*/
    private int seconds;
    private int minutes;
    private AnimationTimer timer;

    public ExtendedGamePane(ExtendedLevel level) {

        MainBoard mainBoard = new MainBoard(level.getLocs(), 4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        int[][] solution = level.solution;

        GeneratedPiece gp3 = new GeneratedPiece(moveChecker,solution,Color.PURPLE,3);
        GeneratedPiece gp4 = new GeneratedPiece(moveChecker,solution,Color.PINK,4);
        GeneratedPiece gp5 = new GeneratedPiece(moveChecker,solution,Color.BLUE,5);
        GeneratedPiece gp6 = new GeneratedPiece(moveChecker,solution,Color.GREEN,6);
        GeneratedPiece gp7 = new GeneratedPiece(moveChecker,solution,Color.GOLD,7);
        GeneratedPiece gp8 = new GeneratedPiece(moveChecker,solution,Color.INDIGO,8);
        GeneratedPiece gp9 = new GeneratedPiece(moveChecker,solution,Color.NAVY,9);
        GeneratedPiece gp10 = new GeneratedPiece(moveChecker,solution,Color.HOTPINK,10);
        GeneratedPiece gp11 = new GeneratedPiece(moveChecker,solution,Color.CHOCOLATE,11);
        GeneratedPiece gp12 = new GeneratedPiece(moveChecker,solution,Color.YELLOW,12);


        getChildren().add(mainBoard);
        getChildren().add(gp3);
        getChildren().add(gp4);
        getChildren().add(gp5);
        getChildren().add(gp6);
        getChildren().add(gp7);
        getChildren().add(gp8);
        getChildren().add(gp9);
        getChildren().add(gp10);
        getChildren().add(gp11);
        getChildren().add(gp12);



        Label lblTime = new Label("Time: 0m 0s");
        seconds = 0;
        minutes = 0;
        timer = new AnimationTimer() {

            long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime != 0) {
                    if (now > lastTime + 1_000_000_000) {
                        if(seconds < 59){
                            seconds++;
                        }
                        else{
                            seconds = 0;
                            minutes++;
                        }
                        lblTime.setText("Time: " + minutes + "m " + seconds + "s" );
                        lastTime = now;
                    }
                } else {
                    lastTime = now;
                }
            }

        };

        timer.start();
        lblTime.setLayoutX(700);
        lblTime.setLayoutY(50);
        Font font = new Font("Times New Roman",25);
        lblTime.setFont(font);
        lblTime.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73;");
        /*counter.setFont(font);

        counter.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73 ;");*/

        getChildren().add(lblTime);









    }


}