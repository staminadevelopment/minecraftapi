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

package pw.stamina.minecraftapi.util;

import pw.stamina.minecraftapi.MinecraftApi;

public interface BoundingBox {

    double getMinX();
    double getMaxX();

    double getMinY();
    double getMaxY();

    double getMinZ();
    double getMaxZ();

    BoundingBox add(double x, double y, double z);
    BoundingBox offset(double x, double y, double z);

    BoundingBox expand(double x, double y, double z);
    BoundingBox contract(double x, double y, double z);

    double calculateXOffset(BoundingBox other, double distance);
    double calculateYOffset(BoundingBox other, double distance);
    double calculateZOffset(BoundingBox other, double distance);

    static BoundingBox fromBounds(double x1, double y1, double z1,
                                  double x2, double y2, double z2) {
        return MinecraftApi.getService(BoundingBoxCreationService.class).fromBounds(x1, y1, z1, x2, y2, z2);
    }

    static BoundingBoxBuilder builder() {
        return new BoundingBoxBuilder();
    }
}
