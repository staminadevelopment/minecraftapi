package pw.stamina.minecraftapi.render;

public interface RenderManager {

    double renderPosX();
    double renderPosY();
    double renderPosZ();

    double viewerPosX();
    double viewerPosY();
    double viewerPosZ();

    float getOriginYOffset();
}
