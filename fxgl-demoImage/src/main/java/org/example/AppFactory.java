package org.example;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;
import static org.example.AppType.IMAGE;

public class AppFactory implements EntityFactory {

@Spawns("image")
public Entity newImage(SpawnData data){

    return entityBuilder()
            .type(IMAGE)
            //.view(new Rectangle(50,50, Color.CADETBLUE))
            //.view("sprite_player.png")
            .viewWithBBox(texture("sprite_player.png",25,25))
            .build();
}
}
