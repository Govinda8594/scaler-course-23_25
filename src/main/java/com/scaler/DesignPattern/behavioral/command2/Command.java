package com.scaler.DesignPattern.behavioral.command2;

import java.util.Stack;

// 1. Command Interface
interface Command {
    void execute();
    void undo();
}

// 2. Receiver (The object being modified)
class TextEditor {
    private StringBuilder content = new StringBuilder();

    public void write(String text) { content.append(text); }
    public void deleteLast(int length) {
        content.delete(content.length() - length, content.length());
    }
    public String getContent() { return content.toString(); }
}

// 3. Concrete Command
class WriteCommand implements Command {
    private TextEditor editor;
    private String text;

    public WriteCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() { editor.write(text); }

    @Override
    public void undo() { editor.deleteLast(text.length()); }
}

// 4. Invoker (Manages Undo/Redo Stacks)
class CommandManager {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear(); // Important: New actions invalidate redo history
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}