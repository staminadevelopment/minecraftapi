package pw.stamina.minecraftapi.entity.living;

import pw.stamina.minecraftapi.entity.Entity;

public interface Living extends Entity {

    float getHealth();
    void setHealth(float health);
}
