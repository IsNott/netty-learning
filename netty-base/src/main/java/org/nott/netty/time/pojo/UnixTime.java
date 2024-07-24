package org.nott.netty.time.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nott
 * @date 2024-7-24
 */
public class UnixTime {

    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date((value() - 2208988800L) * 1000L));
    }
}
