package com.scaler.LLDProject.googledrive;

// CreateFileOperation.java
public class CreateFileOperation extends FileOperation {
    private final Folder folder;
    private final String fileName;

    public CreateFileOperation(Folder folder, String fileName) {
        this.folder = folder;
        this.fileName = fileName;
    }

    @Override
    protected boolean validate() {
        return folder.getChild(fileName) == null;
    }

    @Override
    protected void performOperation() {
        folder.add(new File(fileName));
    }
}