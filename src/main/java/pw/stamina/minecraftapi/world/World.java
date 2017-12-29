package pw.stamina.minecraftapi.world;

import pw.stamina.minecraftapi.entity.Entity;

import java.util.List;

public interface World {

    List<Entity> getLoadedEntities();
}
