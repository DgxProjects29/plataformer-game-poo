package plataformer.entities.effects;

import plataformer.entities.Entity;
import plataformer.entities.Hitbox;

public class CollideEffect implements EntityEffect{

    private Hitbox tileContainer;
    
    public CollideEffect(Hitbox tileContainer) {
        this.tileContainer = tileContainer;
    }

    @Override
    public void apply(Entity entity) {
        
        Hitbox hitbox = entity.getHitbox();

        if (hitbox.b < tileContainer.t || hitbox.t > tileContainer.b || hitbox.l > tileContainer.r
                || hitbox.r < tileContainer.l) {

        } else {

            float collisionTol = 5;
            if (Math.abs(hitbox.b - tileContainer.t) < collisionTol) {
                hitbox.setBottom(tileContainer.t - 0.1f);
            }else if (Math.abs(tileContainer.b - hitbox.t) < collisionTol) {
                hitbox.setTop(tileContainer.b + 0.1f);
            }else if (Math.abs(hitbox.r - tileContainer.l) < collisionTol) {
                hitbox.setRight(tileContainer.l - 0.1f);
            }else if (Math.abs(tileContainer.r - hitbox.l) < collisionTol) {
                hitbox.setLeft(tileContainer.r + 0.1f);
            }

        }

    }
}
