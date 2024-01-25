import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;

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
                .viewWithBBox(new Rectangle(25,25))
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
