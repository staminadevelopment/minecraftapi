/*
 * MIT License
 *
 * Copyright (c) 2017 Stamina Development
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

package pw.stamina.minecraftapi.service;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.ServiceLoader;

//TODO: Clean up... A lot
public final class MinecraftApiServiceRegistry {
    private static final ServiceLoader<MinecraftApiService> SERVICES = ServiceLoader.load(MinecraftApiService.class);
    private static final Map<Class<? extends MinecraftApiService>, MinecraftApiService> CACHED_SERVICES
            = new IdentityHashMap<>();

    public static <T extends MinecraftApiService> T getService(Class<T> serviceClass) {
        return serviceClass.cast(CACHED_SERVICES
                .computeIfAbsent(serviceClass, MinecraftApiServiceRegistry::findService));
    }

    private static MinecraftApiService findService(Class<? extends MinecraftApiService> serviceClass) {
        for (MinecraftApiService service : SERVICES) {
            if (serviceClass.isInstance(service)) {
                return service;
            }
        }

        return null;
    }
}
