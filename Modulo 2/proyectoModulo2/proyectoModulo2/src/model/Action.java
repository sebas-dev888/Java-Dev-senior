package model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Action {
    private String description;
    private long timestamp;

    public Action(String description) {
        this.description = description;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        return String.format("[%s] %s", formatter.format(Instant.ofEpochMilli(timestamp)), description);
    }
}
