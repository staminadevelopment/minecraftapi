package pw.stamina.minecraftapi.client;

import pw.stamina.minecraftapi.entity.Entity;
import pw.stamina.minecraftapi.entity.living.Player;

public interface PlayerController {

    void attackEntity(Player attacker, Entity target);
}
