import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

/**
 * Hello world!
 */
public class App extends GameApplication {
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
        //Agrego actionName
        onKey(KeyCode.A, "Move Left",() -> {
            player.getComponent(PlayerComponent2.class).moveLeft();
        });
        onKey(KeyCode.D, "Move Right",() -> {

            player.getComponent(PlayerComponent2.class).moveRight();
        });
        onKey(KeyCode.W, "Move Up",() -> {

            player.getComponent(PlayerComponent2.class).moveUp();
        });
        onKey(KeyCode.S, "Move Down",() -> {
            player.getComponent(PlayerComponent2.class).moveDown();
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        backround = spawn("background");


        player = spawn("player");
        set("player", player);
        player.setPosition(50, 300);
         }


    //fin----------------------------------------------
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    protected void initPhysics() {
        super.initPhysics();
    }
}
