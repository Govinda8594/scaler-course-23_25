package com.scaler.LLDProject.googledrive;

// FileSystemManager.java
public class FileSystemManager {
    private static FileSystemManager instance;
    private final Folder root;
    private StorageStrategy storageStrategy;

    private FileSystemManager() {
        root = new Folder("root");
        storageStrategy = new LocalStorageStrategy(); // Default Strategy
    }

    public static synchronized FileSystemManager getInstance() {
        if (instance == null) {
            instance = new FileSystemManager();
        }
        return instance;
    }

    public Folder getRoot() {
        return root;
    }

    public StorageStrategy getStorageStrategy() {
        return storageStrategy;
    }

    public void setStorageStrategy(StorageStrategy strategy) {
        this.storageStrategy = strategy;
    }
}