import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.control.Dialog;
import javafx.scene.input.KeyCode;

import static com.almasb.fxgl.dsl.FXGL.*;
/**
 * Hello world!
 *
 */
public class App extends GameApplication{
    private final AppFactory appFactory = new AppFactory();
    private Entity player;
    private Entity backround;


    @Override
    protected void initSettings(GameSettings settings) {

        settings.setTitle("DemoImage");
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initInput() {
        onKey(KeyCode.A, () -> {
            player.translateX(-5.0);
        });
        onKey(KeyCode.D, () -> {
            player.translateX(5.0);
        });
        onKey(KeyCode.W, () -> {
            player.translateY(-5.0);
        });
        onKey(KeyCode.S, () -> {
            player.translateY(5.0);
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        backround = spawn("background");


        player = spawn("player");
        set("player", player);

    }



    //fin----------------------------------------------
    public static void main( String[] args ){
        launch(args);
    }
}
