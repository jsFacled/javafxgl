package com.demo.fxgldemo.components;


import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;


public class PlayerCuboComponent extends Component {

    private PhysicsComponent physics;
    private AnimatedTexture texture;

    private AnimationChannel animIdle, animWalk;

    private int jumps = 2;


    public void left() {

        getEntity().setScaleX(-1);
        physics.setVelocityX(-170);
    }

    public void right() {
        entity.setPosition(+1, entity.getY());
        getEntity().setScaleX(2);

        //physics.setVelocityX(170);
        System.out.println("se movio a la derecha");

    }

    public void stop() {
        //physics.setVelocityX(0);
    }

    public void jump() {
        if (jumps == 0)
            return;

//        physics.setVelocityY(-300);

        jumps--;
    }

}