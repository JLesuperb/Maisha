package maisha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import maisha.tools.SingleTools;

public class Program extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        SingleTools.getInstance().setRootClass(getClass());
        SingleTools.getInstance().setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("fxml/loading.fxml"));
        primaryStage.setTitle("Loading");
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        SingleTools.getInstance().setScene(scene);
        primaryStage.show();
    }
}
