import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import javafx.scene.control.Dialog;

/**
 * Hello world!
 *
 */
public class App extends GameApplication{

    @Override
    protected void initSettings(GameSettings settings) {

        settings.setTitle("DemoImage");
        settings.setWidth(800);
        settings.setHeight(600);
    }

//fin----------------------------------------------
    public static void main( String[] args ){
        launch(args);
    }
}
