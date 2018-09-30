package maisha.controllers;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import maisha.managers.LoginManager;
import maisha.tools.LocalTools;
import maisha.tools.SingleTools;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadingController
{
    @FXML
    public FlowPane rootFlowPane;

    public void initialize()
    {
        Thread thread = new Thread(()->
        {
            try
            {
                Thread.sleep(5000);
                Platform.runLater(this::makeFadeOut);

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void makeFadeOut()
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(rootFlowPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event -> loadLoginPage());
        fadeTransition.play();
    }

    private void loadLoginPage()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(SingleTools.getInstance().getRootClass().getResource("fxml/login.fxml"));
            Stage stage = SingleTools.getInstance().getPrimaryStage();
            stage.setScene(new Scene(loader.load(),400,400));
            //stage.setScene(new Scene(loader.load()));
            stage.setTitle("Login");
            //LocalTools.centerStage(stage);
        }
        catch (IOException ex)
        {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
