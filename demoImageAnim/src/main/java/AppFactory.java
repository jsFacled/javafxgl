import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import javafx.scene.shape.Rectangle;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class AppFactory implements EntityFactory {

    private String imageBackground = "bosque.jpg";

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        return entityBuilder()
                .type(AppType.PLAYER)
                .viewWithBBox(new Rectangle(25,25))
                .with(new PlayerComponentFinal())
                .collidable()
                .build();
    }

    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        return entityBuilder()
                .type(AppType.BACKGROUND)
                .view(imageBackground)
                .zIndex(-10)
                .with(new IrremovableComponent())
                .build();
    }


}//fin
