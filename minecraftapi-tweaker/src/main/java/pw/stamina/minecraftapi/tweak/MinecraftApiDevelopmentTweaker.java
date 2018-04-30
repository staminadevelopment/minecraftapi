/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.tweak;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MinecraftApiDevelopmentTweaker implements ITweaker {
    private final List<String> arguments = new ArrayList<>();

    @Override
    public void acceptOptions(List<String> list, File gameDir, File assetsDir, String profile) {
        arguments.addAll(list);

        if (!arguments.contains("--version") && profile != null) {
            arguments.add("--version");
            arguments.add(profile);
        }

        if (!arguments.contains("--assetsDir") && assetsDir != null) {
            arguments.add("--assetsDir");
            arguments.add(assetsDir.getPath());
        }

        if (!arguments.contains("--gameDir") && gameDir != null) {
            arguments.add("--gameDir");
            arguments.add(gameDir.getPath());
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        excludeLog4JPackages(classLoader);

        MixinBootstrap.init();

        Mixins.addConfiguration("mixins.minecraftapi-core.json");
        Mixins.addConfiguration("mixins.minecraftapi-events.json");

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
        return arguments.toArray(new String[0]);
    }
}
