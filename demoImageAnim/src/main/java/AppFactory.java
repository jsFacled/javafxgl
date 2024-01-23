import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class AppFactory implements EntityFactory {
/*
* Aquì no debería manejar imágenes. Se manejan en Component
* */

    private String imageBackground = "bosque.jpg";
    private String imagePlayer = "sprite_pug.png";

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {

        return entityBuilder()
                .type(AppType.PLAYER)
                .view(imagePlayer)
                .with(new PlayerComponent())
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
