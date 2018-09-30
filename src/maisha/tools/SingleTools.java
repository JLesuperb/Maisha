package maisha.tools;

import javafx.scene.Scene;
import javafx.stage.Stage;
import maisha.Program;
import org.jetbrains.annotations.Contract;

public class SingleTools
{
    private static SingleTools ourInstance = new SingleTools();
    private Class<? extends Program> rootClass;
    private Stage primaryStage;
    private Scene scene;

    @Contract(pure = true)
    public static SingleTools getInstance() {
        return ourInstance;
    }

    private SingleTools()
    {
    }

    public void setRootClass(Class<? extends Program> rootClass)
    {
        this.rootClass = rootClass;
    }

    public Class<? extends Program> getRootClass()
    {
        return rootClass;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
