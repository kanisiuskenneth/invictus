package controller;

import view.GameView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * File: SubmitButton.java
 * Author: 13515033 - Andika Kusuma
 */

public class SubmitButton implements ActionListener, KeyListener {

    private JTextField input_text;
    private GameView game_view;

    public SubmitButton(GameView game_view, JTextField textfield) {
        input_text = textfield;
        this.game_view = game_view;
    }

    @Override
    public void actionPerformed(ActionEvent submitClicked) {
        System.out.println(input_text.getText()+"|");
        game_view.deleteWord(input_text.getText());
        input_text.setText("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("TEST");
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println(input_text.getText()+"}");
            game_view.deleteWord(input_text.getText());
            input_text.setText("");
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // STUB

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}