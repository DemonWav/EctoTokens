package com.demonwav.ectotoken.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public class Util {

    public static byte[] UUIDToByte(UUID uuid) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static UUID byteToUUID(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return new UUID(buffer.getLong(), buffer.getLong());
    }
}