import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.minigames.randomoccurrence.RandomOccurrenceView;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;

public class AppFactory implements EntityFactory {
/*
* Aquì no debería manejar imágenes. Se manejan en Component
* */

    private String imageBackground = "bosque.jpg";
    private String imagePlayer = "sprite_pug.png";
    private AnimatedTexture animatedTexture;

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {

        animatedTexture = texture("sprite_pug.png").subTexture(new Rectangle2D(0, 17, 96, 30)).toAnimatedTexture(3, Duration.seconds(0.6)).loop();


        return entityBuilder()
                .type(AppType.PLAYER)
                //.viewWithBBox(imagePlayer)
                //.view(animatedTexture)
                .with(new PlayerComponent())
                .collidable()



                //No sé para qué sirve
                .bbox(new HitBox(new Point2D(5,5), BoundingShape.circle(12)))
                .bbox(new HitBox(new Point2D(10,25), BoundingShape.box(10, 17)))

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
