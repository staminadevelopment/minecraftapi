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

package pw.stamina.minecraftapi.event.player

import pw.stamina.causam.event.AbstractCancellable
import pw.stamina.minecraftapi.game.entity.living.ClientPlayer
import pw.stamina.minecraftapi.game.network.OutgoingPacket
import pw.stamina.minecraftapi.game.network.Packet
import pw.stamina.minecraftapi.util.CurrentPreviousPair
import pw.stamina.minecraftapi.util.Position
import pw.stamina.minecraftapi.util.Rotation
import java.util.*

class MotionUpdateEvent(
        val player: ClientPlayer,

        position: Position,
        rotation: Rotation,

        val oldPosition: Position,
        val oldRotation: Rotation,

        sprinting: CurrentPreviousPair<Boolean>,
        sneaking: CurrentPreviousPair<Boolean>,

        var onGround: Boolean,
        private val packetSender: (OutgoingPacket) -> Unit
) : AbstractCancellable() {

    var offsetX: Double = 0.0
        private set
    var offsetY: Double = 0.0
        private set
    var offsetZ: Double = 0.0
        private set

    private val packetsDelegate = lazy { LinkedList<OutgoingPacket>() }
    private val actionsDelegate = lazy { LinkedList<() -> Unit>() }

    private val packets by packetsDelegate
    private val actions by actionsDelegate

    var yaw = rotation.yaw
    var pitch = rotation.pitch

    var rotation: Rotation
        get() = Rotation(yaw, pitch)
        set(rotation) {
            yaw = rotation.yaw
            pitch = rotation.pitch
        }

    var x = position.x
        set(x) {
            offsetX += (x - field)
            field = x
        }

    var y = position.y
        set(y) {
            offsetY += (y - field)
            field = y
        }

    var z = position.z
        set(z) {
            offsetY += (z - field)
            field = z
        }

    var position: Position
        get() = Position(x, y, z)
        set(position) {
            x = position.x
            y = position.y
            z = position.z
        }

    fun offset(x: Double, y: Double, z: Double) {
        this.x += x
        this.y += y
        this.z += z
    }

    val isMoving: Boolean
        get() {
            val x = this.x - oldPosition.x
            val y = this.y - oldPosition.y
            val z = this.z - oldPosition.z

            return x * x + y * y + z * z > 9.0E-4
        }

    val isRotating: Boolean
        get() = rotation != oldRotation

    var sprinting = sprinting.current
    val wasSprinting = sprinting.previous

    var sneaking = sneaking.current
    val wasSneaking = sneaking.previous

    fun sendPacket(packet: OutgoingPacket) {
        packetSender(packet)
    }

    fun sendAfter(packet: OutgoingPacket) {
        packets.add(packet)
    }

    fun sendPackets(sender: (OutgoingPacket) -> Unit) {
        if (!packetsDelegate.isInitialized()) {
            return
        }

        packets.forEach(sender)
        packets.clear()
    }

    fun doAfter(action: () -> Unit) {
        actions.add(action)
    }

    fun performActions() {
        if (!packetsDelegate.isInitialized()) {
            return
        }

        actions.forEach { it() }
        actions.clear()
    }
}
