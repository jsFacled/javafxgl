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
           player.getComponent(PlayerComponent.class).asignarMovimiento("left");
            //System.out.println("--++--++--++--++--++--++--++-- imagePlayerY *left* es: "+player.getComponent(PlayerComponent.class).imagePlayerY);
        });
        onKey(KeyCode.D, "Move Right",() -> {
            player.getComponent(PlayerComponent.class).asignarMovimiento("right");
           // System.out.println("--++--++--++--++--++--++--++-- imagePlayerY *right* es: "+player.getComponent(PlayerComponent.class).imagePlayerY);

        });
        onKey(KeyCode.W, "Move Up",() -> {
           player.getComponent(PlayerComponent.class).asignarMovimiento("up");
           // System.out.println("--++--++--++--++--++--++--++-- imagePlayerY * up *es: "+player.getComponent(PlayerComponent.class).imagePlayerY);

        });
        onKey(KeyCode.S, "Move Down",() -> {
           player.getComponent(PlayerComponent.class).asignarMovimiento("down");
          //  System.out.println("--++--++--++--++--++--++--++-- imagePlayerY * down * es: "+player.getComponent(PlayerComponent.class).imagePlayerY);


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
}
