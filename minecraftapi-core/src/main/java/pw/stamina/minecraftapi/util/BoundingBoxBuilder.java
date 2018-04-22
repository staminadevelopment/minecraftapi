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

package pw.stamina.minecraftapi.util;

public final class BoundingBoxBuilder {
    private double x1, y1, z1, x2, y2, z2;

    public BoundingBoxBuilder x1(double x1) {
        this.x1 = x1;
        return this;
    }

    public BoundingBoxBuilder y1(double y1) {
        this.y1 = y1;
        return this;
    }

    public BoundingBoxBuilder z1(double z1) {
        this.z1 = z1;
        return this;
    }

    public BoundingBoxBuilder x2(double x2) {
        this.x2 = x2;
        return this;
    }

    public BoundingBoxBuilder y2(double y2) {
        this.y2 = y2;
        return this;
    }

    public BoundingBoxBuilder z2(double z2) {
        this.z2 = z2;
        return this;
    }

    public BoundingBoxBuilder x(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        return this;
    }

    public BoundingBoxBuilder y(double y1, double y2) {
        this.y1 = y1;
        this.y2 = y2;
        return this;
    }

    public BoundingBoxBuilder z(double z1, double z2) {
        this.z1 = z1;
        this.z2 = z2;
        return this;
    }

    public BoundingBox build() {
        return BoundingBox.fromBounds(x1, y1, z1, x2, y2, z2);
    }
}