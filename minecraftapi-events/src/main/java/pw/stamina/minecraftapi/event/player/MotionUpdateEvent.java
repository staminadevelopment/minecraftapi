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

package pw.stamina.minecraftapi.event.player;

import pw.stamina.causam.event.AbstractCancellable;
import pw.stamina.minecraftapi.entity.living.ClientPlayer;
import pw.stamina.minecraftapi.network.NetHandlerPlayClient;
import pw.stamina.minecraftapi.network.Packet;
import pw.stamina.minecraftapi.util.Rotation;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public final class MotionUpdateEvent extends AbstractCancellable {
    private final ClientPlayer player;

    private double x, y, z;
    private final double oldX, oldY, oldZ;
    private double offsetX, offsetY, offsetZ;

    private float yaw, pitch;
    private final float oldYaw, oldPitch;

    private final boolean wasSneaking, wasSprinting;
    private boolean sneaking, sprinting, onGround;

    private List<Packet> packets;
    private final NetHandlerPlayClient netHandler;

    public MotionUpdateEvent(ClientPlayer player,
                             double x, double y, double z,
                             double oldX, double oldY, double oldZ,

                             float yaw, float pitch,
                             float oldYaw, float oldPitch,

                             boolean sprinting, boolean wasSprinting,
                             boolean sneaking, boolean wasSneaking,
                             boolean onGround,
                             NetHandlerPlayClient netHandler) {
        this.player = player;

        this.x = x;
        this.y = y;
        this.z = z;
        this.oldX = oldX;
        this.oldY = oldY;
        this.oldZ = oldZ;

        this.yaw = yaw;
        this.pitch = pitch;
        this.oldYaw = oldYaw;
        this.oldPitch = oldPitch;

        this.sneaking = sneaking;
        this.wasSneaking = wasSneaking;

        this.sprinting = sprinting;
        this.wasSprinting = wasSprinting;

        this.onGround = onGround;

        this.netHandler = netHandler;
    }

    public ClientPlayer getPlayer() {
        return player;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        offsetX += x - this.x;
        this.x = x;
    }

    public void setY(double y) {
        offsetY += y - this.y;
        this.y = y;
    }

    public void setZ(double z) {
        offsetZ += z - this.z;
        this.z = z;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public double getOldZ() {
        return oldZ;
    }

    public boolean isMoving() {
        double x = this.x - oldX;
        double y = this.y - oldY;
        double z = this.z - oldZ;
        return x * x + y * y + z * z > 9.0E-4D;
    }

    public void offset(double x, double y, double z) {
        setX(this.x + x);
        setY(this.y + y);
        setZ(this.z + z);
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public double getOffsetZ() {
        return offsetZ;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public Rotation getRotation() {
        return Rotation.from(yaw, pitch);
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setRotation(Rotation rotation) {
        yaw = rotation.getYaw();
        pitch = rotation.getPitch();
    }

    public float getOldYaw() {
        return oldYaw;
    }

    public float getOldPitch() {
        return oldPitch;
    }

    public Rotation getOldRotation() {
        return Rotation.from(oldYaw, oldPitch);
    }

    public boolean isRotating() {
        return yaw - oldYaw != 0 || pitch - oldPitch != 0;
    }

    public boolean isSprinting() {
        return sprinting;
    }

    public void setSprinting(boolean sprinting) {
        this.sprinting = sprinting;
    }

    public boolean wasSprinting() {
        return wasSprinting;
    }

    public boolean isSneaking() {
        return sneaking;
    }

    public void setSneaking(boolean sneaking) {
        this.sneaking = sneaking;
    }

    public boolean wasSneaking() {
        return wasSneaking;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void sendPacket(Packet packet) {
        netHandler.queuePacket(packet);
    }

    public void addPacket(Packet packet) {
        if (packets == null) {
            packets = new LinkedList<>();
        }

        packets.add(packet);
    }

    public void sendPackets(Consumer<Packet> sender) {
        if (packets == null) {
            return;
        }

        packets.forEach(sender);
        packets.clear();
    }
}
