package com.quadzillion.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class VanillaLevelsController implements Controllable
{


    public static int vanillaLevel;

    @Override
    public void onCreate()
    {

    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onThemeChange()
    {

    }

    @FXML
    public void onLevelSelected(ActionEvent ae)
    {
        vanillaLevel = (Integer.valueOf(((Button)ae.getSource()).getText().split(" ")[1]) - 1) % 3;



        // DO STUFF ABOUT LEVEL

        Util.addVanillaGamePane();
        Util.setScene(Util.SCENE_PLAY_GAME);
    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {
        Util.removeVanillaChildren();
        Util.setScene(Util.SCENE_MODES);
    }
}
