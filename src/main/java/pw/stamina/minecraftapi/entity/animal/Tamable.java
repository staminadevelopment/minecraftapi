package pw.stamina.minecraftapi.entity.animal;

import pw.stamina.minecraftapi.entity.living.Living;

import java.util.UUID;

public interface Tamable extends Animal {

    boolean isTamed();

    Living getOwner();

    boolean isOwner(Living entity);

    default UUID getOwnerId() {
        try {
            return UUID.fromString(this.getOwnerIdAsString());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    String getOwnerIdAsString();
}
