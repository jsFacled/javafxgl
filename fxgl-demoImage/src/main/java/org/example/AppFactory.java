package org.example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;
import static org.example.AppType.*;
import com.almasb.fxgl.dsl.components.*;
import javafx.util.Duration;
import org.example.components.PlayerComponent;

public class AppFactory implements EntityFactory {

    //-- Configuramos un Pug caminando -- //
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {

        // -- Creación de una textura animada --
        //* FXGL.texture() devuelve un Texture.
        //* toAnimatedTexture() es método de Texture:
        // * * Recibe cantidad de frames y la duración de la animación
        // * * Esos parámetros los maneja internamente como AnimationChannel
        // * * Devuelve un AnimatedTexture
        // --

        AnimatedTexture view = FXGL.texture("lilpuddinpuggums.png").toAnimatedTexture(3, Duration.seconds(0.33));

        return entityBuilder()
                .type(PLAYER)

                .anchorFromCenter()
                .view(view.loop())

                .with(new PlayerComponent())

                .at(getAppWidth()/2,getAppHeight()/2)
                .collidable()
                //.with(new AutoRotationComponent().withSmoothing())//sirve para imagenes vista desde arriba, luego vueve a su vista original.



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
                .collidable()
                .build();
    }

    @Spawns("nave")
    public Entity newNave(SpawnData data) {

        return entityBuilder()
                .type(NAVE)
               .viewWithBBox(texture("sprite_player.png",45,45))
                .collidable()

                .build();
    }

    @Spawns("background")
    public Entity newBaclground(SpawnData data) {
//imagen "bosque"sacada de:
// <a href="https://es.vecteezy.com/vectores-gratis/ver">Ver Vectores por Vecteezy</a>
        return entityBuilder()
                .type(BACKGROUND)

                .view(new ScrollingBackgroundView(FXGL.texture("bosque.jpg").getImage(), getAppWidth(), getAppHeight()))
                //.view("bosque.jpg")
                //.opacity(0.5)


                .zIndex(-1)
                .with(new IrremovableComponent())





                .build();
    }


}//fin
