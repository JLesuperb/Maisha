package maisha.managers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import maisha.controllers.LoginController;
import maisha.controllers.MainViewController;
import maisha.tools.SingleTools;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager
{
    private Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the login application screen.
     */
    public void logout() {
        showLoginScreen();
    }

    private void showLoginScreen()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(SingleTools.getInstance().getRootClass().getResource("fxml/login.fxml"));
            scene.setRoot(loader.load());
        }
        catch (IOException ex)
        {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showMainView(String sessionID) {
        try
        {
            FXMLLoader loader = new FXMLLoader(SingleTools.getInstance().getRootClass().getResource("fxml/main_view.fxml"));
            scene.setRoot(loader.load());
            MainViewController controller = loader.getController();
            controller.initSessionID(this, sessionID);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
