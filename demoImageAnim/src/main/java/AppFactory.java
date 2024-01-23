import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.minigames.randomoccurrence.RandomOccurrenceView;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class AppFactory implements EntityFactory {

    private String imageBackground = "bosque.jpg";
    private String imagePlayer = "sprite_pug.png";

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {

        return entityBuilder()
                .type(AppType.PLAYER)
                .viewWithBBox(imagePlayer)
                //.with(new PlayerComponent())
                .at(getAppWidth()/2,getAppHeight()/2)
                .collidable()
                 .build();

    }

    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        return entityBuilder()
                .type(AppType.BACKGROUND)
                .view(imageBackground)
                .zIndex(-1)
                .with(new IrremovableComponent())
                .build();
    }


}//fin
