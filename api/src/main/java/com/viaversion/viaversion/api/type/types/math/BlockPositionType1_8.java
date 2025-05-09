/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2025 ViaVersion and contributors
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
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BlockPositionType1_8 extends Type<BlockPosition> {

    public BlockPositionType1_8() {
        super(BlockPosition.class);
    }

    @Override
    public BlockPosition read(ByteBuf buffer) {
        final long val = buffer.readLong();
        final long x = (val >> 38);
        final long y = (val << 26) >> 52;
        final long z = (val << 38) >> 38;

        return new BlockPosition((int) x, (short) y, (int) z);
    }

    @Override
    public void write(ByteBuf buffer, BlockPosition object) {
        buffer.writeLong((object.x() & 0X3FFFFFFL) << 38 | (object.y() & 0XFFFL) << 26 | (object.z() & 0X3FFFFFFL));
    }

    public static final class OptionalBlockPositionType extends OptionalType<BlockPosition> {

        public OptionalBlockPositionType() {
            super(Types.BLOCK_POSITION1_8);
        }
    }
}
