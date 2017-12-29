package pw.stamina.minecraftapi.tweak;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class MinecraftApiTweaker implements ITweaker {
    private final ArrayList<String> args = new ArrayList<>();

    @Override
    public void acceptOptions(List<String> list, File gameDir, File assetsDir, String profile) {
        args.addAll(list);

        if (!args.contains("--version") && profile != null) {
            args.add("--version");
            args.add(profile);
        }

        if (!args.contains("--assetsDir") && assetsDir != null) {
            args.add("--assetsDir");
            args.add(assetsDir.getPath());
        }

        if (!args.contains("--gameDir") && gameDir != null) {
            args.add("--gameDir");
            args.add(gameDir.getPath());
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        excludeLog4JPackages(classLoader);
        MixinBootstrap.init();

        Mixins.addConfiguration("mixins.minecraft-api-core.json");
        Mixins.addConfiguration("mixins.minecraft-api-events.json");

        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("notch");

        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }

    // Fixes a bug causing Mixin to crash when injecting from the launcher
    private void excludeLog4JPackages(LaunchClassLoader classLoader) {
        classLoader.addClassLoaderExclusion("org.apache.logging.log4j.");
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return args.toArray(new String[args.size()]);
    }
}
