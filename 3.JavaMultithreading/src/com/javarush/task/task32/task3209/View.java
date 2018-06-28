package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.javarush.task.task32.task3209.ExceptionHandler.*;
import static com.javarush.task.task32.task3209.MenuHelper.*;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Новый")) {
            controller.createNewDocument();
        } else if (actionCommand.equals("Открыть")) {
            controller.openDocument();
        } else if (actionCommand.equals("Сохранить")) {
            controller.saveDocument();
        } else if (actionCommand.equals("Сохранить как...")) {
            controller.saveDocumentAs();
        } else if (actionCommand.equals("Выход")) {
            controller.exit();
        } else if (actionCommand.equals("О программе")) {
            showAbout();
        }
    }

    public void init() {
        initGui();

        addWindowListener(new FrameListener(this));

        setVisible(true);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        initFileMenu(this, menuBar);
        initEditMenu(this, menuBar);
        initStyleMenu(this, menuBar);
        initAlignMenu(this, menuBar);
        initColorMenu(this, menuBar);
        initFontMenu(this, menuBar);
        initHelpMenu(this, menuBar);

        Container container = getContentPane();
        container.add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");

        JScrollPane scrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", scrollPaneHTML);

        JScrollPane scrollPaneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", scrollPaneText);

        tabbedPane.setPreferredSize(new Dimension(800, 600));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        Container container = getContentPane();
        container.add(tabbedPane, BorderLayout.CENTER);
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            String plainText = plainTextPane.getText();
            controller.setPlainText(plainText);
        } else if (tabbedPane.getSelectedIndex() == 1) {
            String plainText = controller.getPlainText();
            plainTextPane.setText(plainText);
        }
        resetUndo();
    }

    public void exit() {
        controller.exit();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this,
                "This program is made to edit HTML. Author: Nikita Koliadin",
                "Info about program",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
