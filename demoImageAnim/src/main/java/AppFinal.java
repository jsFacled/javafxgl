import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import static com.almasb.fxgl.dsl.FXGL.*;

public class AppFinal extends GameApplication {
    private final AppFactory appFactory = new AppFactory();
    private Entity player;
    private Entity background;


    @Override
    protected void initSettings(GameSettings settings) {

        settings.setTitle("DemoImage");
        settings.setWidth(800);
        settings.setHeight(600);
    }


    @Override
    protected void initInput() {
        //Agrego actionName. Luego asigno movimiento a la entidad.
        onKey(KeyCode.A, "Move Left",() -> {
            player.getComponent(PlayerComponentFinal.class).assignMovement(MovementType.LEFT);
        });
        onKey(KeyCode.D, "Move Right",() -> {

            player.getComponent(PlayerComponentFinal.class).assignMovement(MovementType.RIGHT);
        });
        onKey(KeyCode.W, "Move Up",() -> {

            player.getComponent(PlayerComponentFinal.class).assignMovement(MovementType.UP);
        });
        onKey(KeyCode.S, "Move Down",() -> {
            player.getComponent(PlayerComponentFinal.class).assignMovement(MovementType.DOWN);
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(appFactory);

        background = spawn("background");


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

