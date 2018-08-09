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

package pw.stamina.minecraftapi.util

class BoundingBoxBuilder {
    private var x1: Double = 0.toDouble()
    private var y1: Double = 0.toDouble()
    private var z1: Double = 0.toDouble()
    private var x2: Double = 0.toDouble()
    private var y2: Double = 0.toDouble()
    private var z2: Double = 0.toDouble()

    fun x1(x1: Double): BoundingBoxBuilder {
        this.x1 = x1
        return this
    }

    fun y1(y1: Double): BoundingBoxBuilder {
        this.y1 = y1
        return this
    }

    fun z1(z1: Double): BoundingBoxBuilder {
        this.z1 = z1
        return this
    }

    fun x2(x2: Double): BoundingBoxBuilder {
        this.x2 = x2
        return this
    }

    fun y2(y2: Double): BoundingBoxBuilder {
        this.y2 = y2
        return this
    }

    fun z2(z2: Double): BoundingBoxBuilder {
        this.z2 = z2
        return this
    }

    fun x(x1: Double, x2: Double): BoundingBoxBuilder {
        this.x1 = x1
        this.x2 = x2
        return this
    }

    fun y(y1: Double, y2: Double): BoundingBoxBuilder {
        this.y1 = y1
        this.y2 = y2
        return this
    }

    fun z(z1: Double, z2: Double): BoundingBoxBuilder {
        this.z1 = z1
        this.z2 = z2
        return this
    }

    fun build(): BoundingBox {
        return BoundingBox.fromBounds(x1, y1, z1, x2, y2, z2)
    }
}