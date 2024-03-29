package com.demo.fxgldemo.factories;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;

import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.demo.fxgldemo.components.PlayerComponent;
import com.demo.fxgldemo.components.PlayerCuboComponent;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.texture;
import static com.demo.fxgldemo.entitys.demoEntityTipe.*;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */

/*
* La clase DemoFactory se encarga de crear y configurar entidades en el juego
* */
public class DemoFactory implements EntityFactory {

    /**
     * Utilizao solamenteParaPracticar
     *
     * */


    @Spawns("solamenteParaPracticar")
    public Entity practica(SpawnData data) {
        Image i=new Image("player.png");
        return entityBuilder(data)
                .view(texture("sprite_pug.png").subTexture(new Rectangle2D(0,20,i.getWidth(),30)).toAnimatedTexture(3, Duration.seconds(1)).loop())


                .build();
    }


    /**
     * Configurar Entidad Player
     *
     * */

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
       // PhysicsComponent physics = new PhysicsComponent();
        //physics.setBodyType(BodyType.DYNAMIC);
        //physics.addGroundSensor(new HitBox("GROUND_SENSOR", new Point2D(16, 38), BoundingShape.box(6, 8)));

        // this avoids player sticking to walls
        //physics.setFixtureDef(new FixtureDef().friction(0.0f));

        return entityBuilder(data)
                .type(PLAYER)
                .viewWithBBox(new Rectangle(30, 30, Color.BLUE))
                .with(new CollidableComponent(true))//indicamos que puede colisionar, que es colisionable
                .with(new IrremovableComponent())
                .with(new PlayerComponent())
                .build();
    }

    @Spawns("playerCubo")
    public Entity newPlayerCubo(SpawnData data) {

        return entityBuilder(data)
                .type(PLAYERCUBO)
                .viewWithBBox(new Rectangle(100, 30, Color.RED))
                .collidable()//indicamos que puede colisionar, que es colisionable
                .with(new PlayerCuboComponent())
                .build();
    }


    @Spawns("playerCubo2")
    public Entity newPlayerCubo2(SpawnData data) {

        return entityBuilder(data)
                .type(PLAYERCUBO)
                .viewWithBBox(new Rectangle(100, 30, Color.BLUE))
                .collidable()//indicamos que puede colisionar, que es colisionable
                .with(new PlayerCuboComponent())
                .build();
    }
    @Spawns("playerCubo3")
    public Entity newPlayerCubo3(SpawnData data) {

        return entityBuilder(data)
                .type(PLAYERCUBO3)
                //.viewWithBBox(new Rectangle(50, 50, Color.AZURE))
                //.view("player.png")
                .viewWithBBox(texture("sprite_player.png", 40, 40))
                .collidable()//indicamos que puede colisionar, que es colisionable
                .with(new ProjectileComponent(new Point2D(1,0),20))

                .build();
    }
    @Spawns("c1")
    public Entity newC1(SpawnData data) {
var radiusRandom = random(5,55);
        return entityBuilder(data)
                .viewWithBBox(new Circle(radiusRandom, Color.AQUA))//radio random, color
                .collidable()//indicamos que puede colisionar, que es colisionable
                .build();
    }

    //Entity c2 caerá verticalmente
    @Spawns("c2")
    public Entity newC2(SpawnData data) {
        var radiusRandom = random(5,55);
        return entityBuilder(data)
                .viewWithBBox(new Circle(radiusRandom, Color.BISQUE))//radio random, color
                .collidable()//indicamos que puede colisionar, que es colisionable
                .with(new ProjectileComponent(new Point2D(0,1),200))//caída vertical
                .build();

    }
    //Entity rect se moverá horizontalmente
    @Spawns("rect")
    public Entity newRect(SpawnData data) {
        var radiusRandom = random(0,800);
        return entityBuilder(data)
                .view(new Rectangle(50,5,Color.CHARTREUSE))
                .collidable()//indicamos que puede colisionar, que es colisionable
                .with(new ProjectileComponent(new Point2D(1,0),100))//movimiento horizontal
                .build();

    }


/*
    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        return entityBuilder()
                .view(new ScrollingBackgroundView(texture("background/forest.png").getImage(), getAppWidth(), getAppHeight()))
                .zIndex(-1)
                .with(new IrremovableComponent())
                .build();
    }

    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {
        return entityBuilder(data)
                .type(PLATFORM)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("exitTrigger")
    public Entity newExitTrigger(SpawnData data) {
        return entityBuilder(data)
                .type(EXIT_TRIGGER)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }

    @Spawns("doorTop")
    public Entity newDoorTop(SpawnData data) {
        return entityBuilder(data)
                .type(DOOR_TOP)
                .opacity(0)
                .build();
    }

    @Spawns("doorBot")
    public Entity newDoorBot(SpawnData data) {
        return entityBuilder(data)
                .type(DOOR_BOT)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .opacity(0)
                .with(new CollidableComponent(false))
                .build();
    }

    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.addGroundSensor(new HitBox("GROUND_SENSOR", new Point2D(16, 38), BoundingShape.box(6, 8)));

        // this avoids player sticking to walls
        physics.setFixtureDef(new FixtureDef().friction(0.0f));

        return entityBuilder(data)
                .type(PLAYER)
                .bbox(new HitBox(new Point2D(5,5), BoundingShape.circle(12)))
                .bbox(new HitBox(new Point2D(10,25), BoundingShape.box(10, 17)))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new IrremovableComponent())
                .with(new PlayerComponent())
                .build();
    }

    @Spawns("exitSign")
    public Entity newExit(SpawnData data) {
        return entityBuilder(data)
                .type(EXIT_SIGN)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }

    @Spawns("keyPrompt")
    public Entity newPrompt(SpawnData data) {
        return entityBuilder(data)
                .type(KEY_PROMPT)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }

    @Spawns("keyCode")
    public Entity newKeyCode(SpawnData data) {
        String key = data.get("key");

        KeyCode keyCode = KeyCode.getKeyCode(key);

        var lift = new LiftComponent();
        lift.setGoingUp(true);
        lift.yAxisDistanceDuration(6, Duration.seconds(0.76));

        var view = new KeyView(keyCode, Color.YELLOW, 24);
        view.setCache(true);
        view.setCacheHint(CacheHint.SCALE);

        return entityBuilder(data)
                .view(view)
                .with(lift)
                .zIndex(100)
                .build();
    }

    @Spawns("button")
    public Entity newButton(SpawnData data) {
        var keyEntity = getGameWorld().create("keyCode", new SpawnData(data.getX(), data.getY() - 50).put("key", "E"));
        keyEntity.getViewComponent().setOpacity(0);

        return entityBuilder(data)
                .type(BUTTON)
                .viewWithBBox(texture("button.png", 20, 18))
                .with(new CollidableComponent(true))
                .with("keyEntity", keyEntity)
                .build();
    }

//    @Spawns("messagePrompt")
//    public Entity newMessagePrompt(SpawnData data) {
//        var text = getUIFactoryService().newText(data.get("message"), Color.BLACK, FontType.GAME, 20.0);
//        text.setStrokeWidth(2);
//
//        return entityBuilder(data)
//                .type(MESSAGE_PROMPT)
//                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
//                .view(text)
//                .with(new CollidableComponent(true))
//                .opacity(0)
//                .build();
//    }

 */
}

