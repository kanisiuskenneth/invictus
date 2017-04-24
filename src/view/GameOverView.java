package view;

import controller.ImageLoader;
import model.game.GameModel;
import model.main.MainModel;
import sun.swing.SwingAccessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kennethhalim on 4/24/17.
 */
public class GameOverView {
    Container old;
    JPanel current_panel;

    public GameOverView(GameModel gameModel) {
        old = MainFrame.mainframe.getContentPane();
        current_panel = new JPanel();
        current_panel.setLayout(new BorderLayout());
        current_panel.setSize(MainFrame.width, MainFrame.height);
        current_panel.setBackground(MainFrame.DARK_GRAY);
        MainFrame.mainframe.setContentPane(current_panel);
        int head_width = MainFrame.widthToPx(60);
        int head_height = head_width * ImageLoader.gameover_banner.getHeight() /
                ImageLoader.gameover_banner.getWidth();
        JLabel head_banner = new JLabel(new ImageIcon(
                ImageLoader.gameover_banner.getScaledInstance(head_width, head_height, Image.SCALE_DEFAULT)));
        head_banner.setBorder(new EmptyBorder(30,0,0,0));
        current_panel.add(head_banner, BorderLayout.NORTH);
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2,2));
        JLabel scoreLabel = displayLabel("Score");
        JLabel scoreGet = displayLabel(": "+Math.round(gameModel.player.getScore()*MainModel.score_multiplier));
        JLabel coinLabel = displayLabel("Coin");
        JLabel coinGet = displayLabel(": "+Math.round(gameModel.player.getScore()/100 * MainModel.coin_multiplier));
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreGet);
        scorePanel.add(coinLabel);
        scorePanel.add(coinGet);
        scorePanel.setBackground(new Color(100,100,100));
        current_panel.add(scorePanel,BorderLayout.CENTER);
        current_panel.repaint();

        MainFrame.mainframe.setVisible(true);
    }
    private JLabel displayLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont( new Font("Helvetica",Font.BOLD,40));
        label.setForeground(Color.WHITE);
        return label;
    }
    public void close() {
        current_panel.removeAll();
        MainFrame.mainframe.remove(current_panel);
        MainFrame.mainframe.setContentPane(old);
    }
}
