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
import javafx.geometry.Rectangle2D;
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
    //La imagen mide 96x192
    @Spawns("playerAnimado")
    public Entity newPlayerAnimado(SpawnData data) {
        String urlImage = "sprite_pug.png";
        Image i = image(urlImage);

        AnimatedTexture animTextureFrenteAndDown, animTextureIzquierda, animTextureDerecha, animTextureUp;

        int framesPerRow =3;
        int frameWidth = 96;
        int frameHeight = 192;
        Duration channelDuration =Duration.seconds(1);
        int startFrame=1;
        int endFrame=4;

        AnimationChannel channelFrente = new AnimationChannel(i,framesPerRow,frameWidth,frameHeight,channelDuration,startFrame,endFrame);
        AnimatedTexture textureFrente = new AnimatedTexture(channelFrente);

         animTextureFrenteAndDown=texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureDerecha=texture("sprite_pug.png").subTexture(new Rectangle2D(0,117,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureIzquierda=texture("sprite_pug.png").subTexture(new Rectangle2D(0,71,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();
        animTextureUp=texture("sprite_pug.png").subTexture(new Rectangle2D(0,162,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(0.6)).loop();


        return entityBuilder()
                .type(PLAYERANIMADO)
                // --  lee la imagen, capta un rectángulo de la misma, la convierte en una textura animada y al final hace un loop de la animación.--//
               // .view(texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3,Duration.seconds(1)).loop())
                .view(animTextureUp)
                //.viewWithBBox(texture("sprite_pug.png", 50, 50))

                .at(getAppWidth()/3,getAppHeight()/3)
                .collidable()

                .build();
// TODO: 21/01/2024 colocar cada imagen animada según camine hacia izq-der-arriba-abajo

    }

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {

        // -- Creación de una textura animada --
        //* FXGL.texture() devuelve un Texture que es de fxgl pero extiende de ImageView que es de javafx.scene.image.
        //* toAnimatedTexture() es método de Texture:
        // * * Recibe cantidad de frames y la duración de la animación
        // * * Esos parámetros los maneja internamente como AnimationChannel
        // * * Devuelve un AnimatedTexture que es un Texture, por lo tanto es un Node.
        // --
        // * .view recibe un Node que es de javafx.scene y lo agrega al ViewComponent().
        //* Por lo tanto Texture es un Node.

        AnimatedTexture view = FXGL.texture("sprite_pug.png").toAnimatedTexture(3, Duration.seconds(0.33));

        return entityBuilder()
                .type(PLAYER)

                .anchorFromCenter()
                //.view(view.loop())
                .view(view)

                //.with(new PlayerComponent())

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
