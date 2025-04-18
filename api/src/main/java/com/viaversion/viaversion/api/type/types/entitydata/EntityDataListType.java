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
package com.viaversion.viaversion.api.type.types.entitydata;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;

public final class EntityDataListType extends EntityDataListTypeTemplate {
    private final Type<EntityData> type;

    public EntityDataListType(Type<EntityData> type) {
        Preconditions.checkNotNull(type);
        this.type = type;
    }

    @Override
    public List<EntityData> read(final ByteBuf buffer) {
        final List<EntityData> list = new ArrayList<>();
        EntityData data;
        do {
            data = this.type.read(buffer);
            if (data != null) {
                list.add(data);
            }
        } while (data != null);
        return list;
    }

    @Override
    public void write(final ByteBuf buffer, final List<EntityData> object) {
        for (final EntityData data : object) {
            this.type.write(buffer, data);
        }
        this.type.write(buffer, null);
    }
}
