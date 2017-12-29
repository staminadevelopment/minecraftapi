package pw.stamina.minecraftapi.mixin.event.render;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import pw.stamina.minecraftapi.MinecraftApi;
import pw.stamina.minecraftapi.event.render.LightmapUpdateEvent;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public abstract class MixinLightmapUpdateEvent {

    /**
     * @author
     */
    @Overwrite
    private void updateLightmap(float p_updateLightmap_1_) {
        if (this.lightmapUpdateNeeded) {
            this.mc.mcProfiler.startSection("lightTex");
            World lvt_2_1_ = this.mc.theWorld;
            if (lvt_2_1_ != null) {
                float lvt_3_1_ = lvt_2_1_.getSunBrightness(1.0F);
                float lvt_4_1_ = lvt_3_1_ * 0.95F + 0.05F;

                LightmapUpdateEvent event = new LightmapUpdateEvent();
                MinecraftApi.emitEvent(event);

                for(int lvt_5_1_ = 0; lvt_5_1_ < 256; ++lvt_5_1_) {
                    float lvt_6_1_ = lvt_2_1_.provider.getLightBrightnessTable()[lvt_5_1_ / 16] * lvt_4_1_;
                    float lvt_7_1_ = lvt_2_1_.provider.getLightBrightnessTable()[lvt_5_1_ % 16] * (this.torchFlickerX * 0.1F + 1.5F);
                    if (lvt_2_1_.getLastLightningBolt() > 0) {
                        lvt_6_1_ = lvt_2_1_.provider.getLightBrightnessTable()[lvt_5_1_ / 16];
                    }

                    float lvt_8_1_ = lvt_6_1_ * (lvt_3_1_ * 0.65F + 0.35F);
                    float lvt_9_1_ = lvt_6_1_ * (lvt_3_1_ * 0.65F + 0.35F);
                    float lvt_12_1_ = lvt_7_1_ * ((lvt_7_1_ * 0.6F + 0.4F) * 0.6F + 0.4F);
                    float lvt_13_1_ = lvt_7_1_ * (lvt_7_1_ * lvt_7_1_ * 0.6F + 0.4F);
                    float lvt_14_1_ = lvt_8_1_ + lvt_7_1_;
                    float lvt_15_1_ = lvt_9_1_ + lvt_12_1_;
                    float lvt_16_1_ = lvt_6_1_ + lvt_13_1_;
                    lvt_14_1_ = lvt_14_1_ * 0.96F + 0.03F;
                    lvt_15_1_ = lvt_15_1_ * 0.96F + 0.03F;
                    lvt_16_1_ = lvt_16_1_ * 0.96F + 0.03F;
                    float lvt_17_3_;
                    if (this.bossColorModifier > 0.0F) {
                        lvt_17_3_ = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * p_updateLightmap_1_;
                        lvt_14_1_ = lvt_14_1_ * (1.0F - lvt_17_3_) + lvt_14_1_ * 0.7F * lvt_17_3_;
                        lvt_15_1_ = lvt_15_1_ * (1.0F - lvt_17_3_) + lvt_15_1_ * 0.6F * lvt_17_3_;
                        lvt_16_1_ = lvt_16_1_ * (1.0F - lvt_17_3_) + lvt_16_1_ * 0.6F * lvt_17_3_;
                    }

                    if (lvt_2_1_.provider.getDimensionId() == 1) {
                        lvt_14_1_ = 0.22F + lvt_7_1_ * 0.75F;
                        lvt_15_1_ = 0.28F + lvt_12_1_ * 0.75F;
                        lvt_16_1_ = 0.25F + lvt_13_1_ * 0.75F;
                    }

                    float lvt_18_2_;
                    if (this.mc.thePlayer.isPotionActive(Potion.nightVision)) {
                        lvt_17_3_ = this.getNightVisionBrightness(this.mc.thePlayer, p_updateLightmap_1_);
                        lvt_18_2_ = 1.0F / lvt_14_1_;
                        if (lvt_18_2_ > 1.0F / lvt_15_1_) {
                            lvt_18_2_ = 1.0F / lvt_15_1_;
                        }

                        if (lvt_18_2_ > 1.0F / lvt_16_1_) {
                            lvt_18_2_ = 1.0F / lvt_16_1_;
                        }

                        lvt_14_1_ = lvt_14_1_ * (1.0F - lvt_17_3_) + lvt_14_1_ * lvt_18_2_ * lvt_17_3_;
                        lvt_15_1_ = lvt_15_1_ * (1.0F - lvt_17_3_) + lvt_15_1_ * lvt_18_2_ * lvt_17_3_;
                        lvt_16_1_ = lvt_16_1_ * (1.0F - lvt_17_3_) + lvt_16_1_ * lvt_18_2_ * lvt_17_3_;
                    }

                    if (lvt_14_1_ > 1.0F) {
                        lvt_14_1_ = 1.0F;
                    }

                    if (lvt_15_1_ > 1.0F) {
                        lvt_15_1_ = 1.0F;
                    }

                    if (lvt_16_1_ > 1.0F) {
                        lvt_16_1_ = 1.0F;
                    }

                    lvt_17_3_ = this.mc.gameSettings.gammaSetting;
                    lvt_18_2_ = 1.0F - lvt_14_1_;
                    float lvt_19_1_ = 1.0F - lvt_15_1_;
                    float lvt_20_1_ = 1.0F - lvt_16_1_;
                    lvt_18_2_ = 1.0F - lvt_18_2_ * lvt_18_2_ * lvt_18_2_ * lvt_18_2_;
                    lvt_19_1_ = 1.0F - lvt_19_1_ * lvt_19_1_ * lvt_19_1_ * lvt_19_1_;
                    lvt_20_1_ = 1.0F - lvt_20_1_ * lvt_20_1_ * lvt_20_1_ * lvt_20_1_;
                    lvt_14_1_ = lvt_14_1_ * (1.0F - lvt_17_3_) + lvt_18_2_ * lvt_17_3_;
                    lvt_15_1_ = lvt_15_1_ * (1.0F - lvt_17_3_) + lvt_19_1_ * lvt_17_3_;
                    lvt_16_1_ = lvt_16_1_ * (1.0F - lvt_17_3_) + lvt_20_1_ * lvt_17_3_;
                    lvt_14_1_ = lvt_14_1_ * 0.96F + 0.03F;
                    lvt_15_1_ = lvt_15_1_ * 0.96F + 0.03F;
                    lvt_16_1_ = lvt_16_1_ * 0.96F + 0.03F;
                    if (lvt_14_1_ > 1.0F) {
                        lvt_14_1_ = 1.0F;
                    }

                    if (lvt_15_1_ > 1.0F) {
                        lvt_15_1_ = 1.0F;
                    }

                    if (lvt_16_1_ > 1.0F) {
                        lvt_16_1_ = 1.0F;
                    }

                    if (lvt_14_1_ < 0.0F) {
                        lvt_14_1_ = 0.0F;
                    }

                    if (lvt_15_1_ < 0.0F) {
                        lvt_15_1_ = 0.0F;
                    }

                    if (lvt_16_1_ < 0.0F) {
                        lvt_16_1_ = 0.0F;
                    }

                    int lvt_21_1_ = 255;
                    int lvt_22_1_ = (int)(lvt_14_1_ * 255.0F);
                    int lvt_23_1_ = (int)(lvt_15_1_ * 255.0F);
                    int lvt_24_1_ = (int)(lvt_16_1_ * 255.0F);
                    this.lightmapColors[lvt_5_1_] = event.calculate(lvt_22_1_, lvt_23_1_, lvt_24_1_, lvt_21_1_,
                            lvt_21_1_ << 24 | lvt_22_1_ << 16 | lvt_23_1_ << 8 | lvt_24_1_);
                }

                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }

    @Shadow private boolean lightmapUpdateNeeded;
    @Shadow private net.minecraft.client.Minecraft mc;
    @Shadow private float bossColorModifier;
    @Shadow private float bossColorModifierPrev;
    @Shadow private float torchFlickerX;
    @Shadow protected abstract float getNightVisionBrightness(EntityLivingBase p_getNightVisionBrightness_1_, float p_getNightVisionBrightness_2_);
    @Shadow @Final private int[] lightmapColors;
    @Shadow @Final private DynamicTexture lightmapTexture;
}
