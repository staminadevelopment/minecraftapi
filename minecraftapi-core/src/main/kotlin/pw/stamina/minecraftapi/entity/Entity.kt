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

package pw.stamina.minecraftapi.entity

import pw.stamina.minecraftapi.util.BoundingBox
import pw.stamina.minecraftapi.util.Rotation
import java.util.*

interface Entity {

    val entityId: Int
    val uniqueId: UUID

    val riddenByEntities: List<Entity>

    var rotation: Rotation
        get() = Rotation(yaw, pitch)
        set(rotation) {
            yaw = rotation.yaw
            pitch = rotation.pitch
        }

    val boundingBox: BoundingBox

    val isDead: Boolean

    val eyeHeight: Float

    var isNoClipping: Boolean

    val ticksExisted: Int

    var posX: Double
    var posY: Double
    var posZ: Double

    val prevPosX: Double
    val prevPosY: Double
    val prevPosZ: Double

    var motionX: Double
    var motionY: Double
    var motionZ: Double

    var yaw: Float
    var pitch: Float

    var onGround: Boolean

    val width: Float
    val height: Float

    fun getDistanceToEntity(other: Entity): Float
}
