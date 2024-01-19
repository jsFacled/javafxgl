package org.example;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.random;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;
import static org.example.AppType.*;

public class AppFactory implements EntityFactory {

    @Spawns("image")
    public Entity newImage(SpawnData data) {

        return entityBuilder()
                .type(IMAGE)
                //.view(new Rectangle(50,50, Color.CADETBLUE))
                //.view("sprite_player.png")
                .viewWithBBox(texture("bfrances.png",32,37))
                .at(300,500)
                .build();


    }

    @Spawns("huesoAleatorio")
    public Entity newHuesoAleatorio(SpawnData data) {
        var ax = random(25, 800);
        var ay = random(25, 600);

        return entityBuilder()
                .type(HUESO)
                //.view(new Rectangle(50,50, Color.CADETBLUE))
                //.view("sprite_player.png")
                .viewWithBBox(texture("hueso.png",15,15))
                .at(ax,ay)
                .build();
    }

    @Spawns("nave")
    public Entity newNave(SpawnData data) {

        return entityBuilder()
                .type(NAVE)
               .view("sprite_player.png")
                .build();
    }

}//fin
