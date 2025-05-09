/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2025 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.packet;

import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;

public enum ServerboundPackets1_9 implements ServerboundPacketType {

    ACCEPT_TELEPORTATION, // 0x00
    COMMAND_SUGGESTION, // 0x01
    CHAT, // 0x02
    CLIENT_COMMAND, // 0x03
    CLIENT_INFORMATION, // 0x04
    CONTAINER_ACK, // 0x05
    CONTAINER_BUTTON_CLICK, // 0x06
    CONTAINER_CLICK, // 0x07
    CONTAINER_CLOSE, // 0x08
    CUSTOM_PAYLOAD, // 0x09
    INTERACT, // 0x0A
    KEEP_ALIVE, // 0x0B
    MOVE_PLAYER_POS, // 0x0C
    MOVE_PLAYER_POS_ROT, // 0x0D
    MOVE_PLAYER_ROT, // 0x0E
    MOVE_PLAYER_STATUS_ONLY, // 0x0F
    MOVE_VEHICLE, // 0x10
    PADDLE_BOAT, // 0x11
    PLAYER_ABILITIES, // 0x12
    PLAYER_ACTION, // 0x13
    PLAYER_COMMAND, // 0x14
    PLAYER_INPUT, // 0x15
    RESOURCE_PACK, // 0x16
    SET_CARRIED_ITEM, // 0x17
    SET_CREATIVE_MODE_SLOT, // 0x18
    SIGN_UPDATE, // 0x19
    SWING, // 0x1A
    TELEPORT_TO_ENTITY, // 0x1B
    USE_ITEM_ON, // 0x1C
    USE_ITEM; // 0x1D

    @Override
    public int getId() {
        return ordinal();
    }

    @Override
    public String getName() {
        return name();
    }
}
