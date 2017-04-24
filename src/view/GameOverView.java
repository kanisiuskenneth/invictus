package view;

import controller.ImageLoader;
import model.game.GameModel;
import model.main.MainModel;
import sun.applet.Main;
import sun.swing.SwingAccessor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
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
        int dummyWidth = MainFrame.widthToPx(40);
        int dummyHeight = MainFrame.height;
        JLabel bottomDummy = new JLabel(
                new ImageIcon(ImageLoader.SPACER.getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
        JLabel leftDummy = new JLabel(
                new ImageIcon(ImageLoader.SPACER.getScaledInstance(dummyWidth, dummyHeight, Image.SCALE_DEFAULT)));

        JLabel rightDummy = new JLabel(
                new ImageIcon(ImageLoader.SPACER.getScaledInstance(dummyWidth, dummyHeight, Image.SCALE_DEFAULT)));
        current_panel.add(leftDummy, BorderLayout.WEST);
        current_panel.add(rightDummy, BorderLayout.EAST);
        JLabel head_banner = new JLabel(new ImageIcon(
                ImageLoader.gameover_banner.getScaledInstance(head_width, head_height, Image.SCALE_DEFAULT)));
        head_banner.setBorder(new EmptyBorder(30, 0, 0, 0));
        current_panel.add(head_banner, BorderLayout.NORTH);
        JPanel scorePanel = new JPanel();
        long score = Math.round(gameModel.player.getScore()*MainModel.score_multiplier);
        long coin = Math.round(gameModel.player.getScore()*MainModel.coin_multiplier/100);
        scorePanel.setLayout(new GridLayout(2, 2));
        JLabel scoreLabel = displayLabel("Score");
        JLabel scoreGet = displayLabel(": " +score);
        JLabel coinLabel = displayLabel("Coin");
        JLabel cointGet = displayLabel(":" +coin);
        scorePanel.add(scoreLabel);
        scorePanel.add(scoreGet);
        scorePanel.add(coinLabel);
        scorePanel.add(cointGet);
        JPanel enterNamePanel = new JPanel();
        enterNamePanel.setLayout(new BorderLayout());
        int enterNameHeight  = MainFrame.heightToPx(10);
        int enterNameWidth = 5*enterNameHeight;
        JLabel enterNameLabel = new JLabel(new ImageIcon(
                ImageLoader.enterName.getScaledInstance(enterNameWidth,enterNameHeight,Image.SCALE_DEFAULT)));
        enterNamePanel.add(enterNameLabel,BorderLayout.NORTH);
        JTextField enterNameField = new JTextField();
        enterNameField.setFont(new Font("Serif",Font.BOLD,40));
        enterNameField.setHorizontalAlignment(SwingConstants.CENTER);
        enterNameField.setOpaque(false);

        enterNameField.setForeground(Color.WHITE);
        enterNamePanel.setBorder(new EmptyBorder(30,0,100,0));
        enterNameField.setBorder(new MatteBorder(2,0,2,0,Color.WHITE));
        enterNamePanel.setBackground(MainFrame.DARK_GRAY);
        int back_width = MainFrame.widthToPx(30);
        int back_height = back_width * ImageLoader.back_button.getHeight() / ImageLoader.back_button.getWidth();
        JPanel bottomPanel = new JPanel();

        bottomPanel.setBackground(MainFrame.DARK_GRAY);
        bottomPanel.setLayout(new BorderLayout());
        JButton back = new JButton(new ImageIcon(ImageLoader.back_button.getScaledInstance(
                back_width, back_height, Image.SCALE_DEFAULT
        )));
        enterNamePanel.add(enterNameField,BorderLayout.SOUTH);

        if(score > MainModel.leaderboard[4].second)
            bottomPanel.add(enterNamePanel,BorderLayout.NORTH);
        else
            bottomPanel.add(bottomDummy,BorderLayout.NORTH);

        bottomPanel.setBorder(new EmptyBorder(0, 0, 60, 0));
        bottomPanel.add(back, BorderLayout.SOUTH);
        current_panel.add(bottomPanel, BorderLayout.SOUTH);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_panel.removeAll();
                MainFrame.mainframe.remove(current_panel);
                MainFrame.mainframe.setContentPane(gameModel.menupanel);
            }
        });

        back.setBorder(BorderFactory.createEmptyBorder());
        back.setContentAreaFilled(false);
        scorePanel.setBackground(MainFrame.DARK_GRAY);
        current_panel.add(scorePanel, BorderLayout.CENTER);
        current_panel.repaint();
        enterNameField.requestFocus();
        MainFrame.mainframe.setVisible(true);
    }

    private JLabel displayLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Helvetica", Font.BOLD, 40));
        label.setForeground(Color.WHITE);
        return label;
    }

    public void close() {
        current_panel.removeAll();
        MainFrame.mainframe.remove(current_panel);
        MainFrame.mainframe.setContentPane(old);
    }
}
