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

package pw.stamina.minecraftapi.game.entity

import pw.stamina.minecraftapi.game.util.BoundingBox
import pw.stamina.minecraftapi.util.Motion
import pw.stamina.minecraftapi.util.Position
import pw.stamina.minecraftapi.util.Rotation
import java.util.*

/**
 * Represents any entity in the game.
 */
interface Entity {

    /**
     * Returns the world specific id of the entity.
     */
    val entityId: Int

    /**
     * Returns the unique id of the entity.
     */
    val uniqueId: UUID

    /**
     * The center x position of the entity.
     */
    var posX: Double

    /**
     * The feet y position of the entity.
     */
    var posY: Double

    /**
     * The center z position of the entity.
     */
    var posZ: Double

    /**
     * The current position of the entity.
     */
    var position: Position
        get() = Position(posX, posY, posZ)
        set(position) {
            posX = position.x
            posY = position.y
            posZ = position.z
        }

    /**
     * The previous center x position of the entity.
     */
    val previousPosX: Double

    /**
     * The previous feet y position of the entity.
     */
    val previousPosY: Double

    /**
     * The previous center z position of the entity.
     */
    val previousPosZ: Double

    /**
     * The previous position of the entity.
     */
    val previousPosition: Position
        get() = Position(previousPosX, previousPosY, previousPosZ)

    /**
     * The x-axis motion of the entity.
     */
    var motionX: Double

    /**
     * The y-axis motion of the entity.
     */
    var motionY: Double

    /**
     * The z-axis motion of the entity.
     */
    var motionZ: Double

    /**
     * The motion of the entity.
     */
    var motion: Motion
        get() = Motion(motionX, motionY, motionZ)
        set(motion) {
            motionX = motion.x
            motionY = motion.y
            motionZ = motion.z
        }

    /**
     * The yaw rotation of the entity.
     */
    var yaw: Float

    /**
     * The pitch rotation of the entity.
     */
    var pitch: Float

    /**
     * The yaw and pitch rotations of the entity.
     */
    var rotation: Rotation
        get() = Rotation(yaw, pitch)
        set(rotation) {
            yaw = rotation.yaw
            pitch = rotation.pitch
        }

    /**
     * The on ground state of the entity.
     */
    var onGround: Boolean

    /**
     * Returns the bounding box of the entity.
     */
    val boundingBox: BoundingBox

    /**
     * Returns a list of the entities the entity is ridden by.
     */
    val riddenByEntities: List<Entity>

    /**
     * Returns `true` if the entity is dead, otherwise `false`.
     */
    val isDead: Boolean

    /**
     * Returns the height between the feet and eyes of the entity.
     */
    val eyeHeight: Double

    /**
     * Returns the amount of in-game ticks the entity has existed for.
     */
    val ticksExisted: Int

    /**
     * Returns the width of the entity.
     */
    val width: Double

    /**
     * Returns the height of the entity.
     */
    val height: Double

    /**
     * Returns the distance between the entity and [other].
     */
    fun getDistanceToEntity(other: Entity): Double
}
