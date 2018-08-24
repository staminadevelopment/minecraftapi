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

package pw.stamina.minecraftapi.game.util

import pw.stamina.minecraftapi.MinecraftApi
import pw.stamina.minecraftapi.util.Position

interface BoundingBox {

    val minX: Double

    val maxX: Double

    val minY: Double

    val maxY: Double

    val minZ: Double

    val maxZ: Double

    fun expand(x: Double, y: Double, z: Double): BoundingBox

    fun contract(x: Double, y: Double, z: Double): BoundingBox

    fun offset(x: Double, y: Double, z: Double): BoundingBox

    fun grow(x: Double, y: Double, z: Double): BoundingBox

    fun shrink(x: Double, y: Double, z: Double): BoundingBox

    fun calculateXOffset(other: BoundingBox, distance: Double): Double

    fun calculateYOffset(other: BoundingBox, distance: Double): Double

    fun calculateZOffset(other: BoundingBox, distance: Double): Double

    interface Factory {
        fun create(x1: Double, y1: Double, z1: Double,
                   x2: Double, y2: Double, z2: Double): BoundingBox
    }

    companion object {
        private val boundingBoxFactory = MinecraftApi.getAdapter().boundingBoxFactory

        fun fromBounds(x1: Double, y1: Double, z1: Double,
                       x2: Double, y2: Double, z2: Double) =
                boundingBoxFactory.create(x1, y1, z1, x2, y2, z2)

        fun fromPositions(position1: Position, position2: Position) =
                fromBounds(
                        position1.x, position1.y, position1.z,
                        position2.x, position2.y, position2.z)
    }
}
