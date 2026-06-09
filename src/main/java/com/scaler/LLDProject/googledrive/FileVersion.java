package com.scaler.LLDProject.googledrive;

// FileVersion.java
public class FileVersion {
    private final String content;
    private final long timestamp;

    public FileVersion(String content) {
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}