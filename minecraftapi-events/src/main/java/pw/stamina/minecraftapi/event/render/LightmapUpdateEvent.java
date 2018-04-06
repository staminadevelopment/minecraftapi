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

package pw.stamina.minecraftapi.event.render;

public final class LightmapUpdateEvent {
    private static final LightmapCalculator DEFAULT_LIGHTMAP_CALCULATOR =
            (red, green, blue, color) -> color;

    private LightmapCalculator calculator;
    private boolean shouldForceLightUpdate;

    public LightmapUpdateEvent() {
        this.calculator = DEFAULT_LIGHTMAP_CALCULATOR;
    }

    public void forceLightUpdate() {
        shouldForceLightUpdate = true;
    }

    public boolean isLightUpdateForced() {
        return shouldForceLightUpdate;
    }

    public void setCalculator(LightmapCalculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(int red, int green, int blue, int color) {
        return calculator.calculate(red, green, blue, color);
    }

    @FunctionalInterface
    public interface LightmapCalculator {

        int calculate(int red, int green, int blue, int color);
    }
}
