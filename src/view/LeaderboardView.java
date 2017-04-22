package view;

import controller.ImageLoader;
import model.main.MainModel;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kennethhalim on 4/22/17.
 */
public class LeaderboardView {
    Container old;
    JPanel current_panel;

    public LeaderboardView() {
        old = MainFrame.mainframe.getContentPane();
        current_panel = new JPanel();
        current_panel.setLayout(new BorderLayout());
        current_panel.setSize(MainFrame.width,MainFrame.height);
        current_panel.setBackground(MainFrame.DARK_GRAY);
        MainFrame.mainframe.setContentPane(current_panel);
        int head_width = MainFrame.widthToPx(60);
        int head_height = head_width*ImageLoader.leaderboard_banner.getHeight()/
                ImageLoader.leaderboard_banner.getWidth();
        JLabel head_banner = new JLabel(new ImageIcon(
                ImageLoader.leaderboard_banner.getScaledInstance(head_width,head_height,Image.SCALE_DEFAULT)));
        current_panel.add(head_banner,BorderLayout.NORTH);
        JPanel items = new JPanel();
        current_panel.add(items,BorderLayout.CENTER);
        items.setLayout(new GridLayout(8,3));
        ImageIcon spacer = new ImageIcon(ImageLoader.SPACER.getScaledInstance(MainFrame.widthToPx(25),
                MainFrame.heightToPx(100), Image.SCALE_DEFAULT));
        current_panel.add(new JLabel(spacer),BorderLayout.WEST);

        current_panel.add(new JLabel(spacer),BorderLayout.EAST);
        items.setBackground(MainFrame.DARK_GRAY);
        for(int i=0;i<5;i++) {
            JPanel item_panel = new JPanel(new BorderLayout());
            JLabel item_label_name = new JLabel(MainModel.leaderboard[i].first);
            JLabel item_label_score = new JLabel(MainModel.leaderboard[i].second.toString());
            item_panel.setBackground(MainFrame.DARK_GRAY);
            item_label_name.setFont(new Font("Courier New",Font.PLAIN,40));
            item_label_score.setFont(new Font("Courier New",Font.PLAIN,40));
            if(i==0) {
                item_label_name.setForeground(Color.GREEN);
                item_label_score.setForeground(Color.GREEN);

            } else {
                item_label_name.setForeground(Color.WHITE);
                item_label_score.setForeground(Color.WHITE);
            }
            item_panel.add(item_label_name,BorderLayout.WEST);
            item_panel.add(item_label_score,BorderLayout.EAST);
            items.add(item_panel);
            item_panel.setVisible(true);
        }
        items.setVisible(true);
        head_banner.setVisible(true);
        int back_width = MainFrame.widthToPx(30);
        int back_height = back_width*ImageLoader.back_button.getHeight()/ImageLoader.back_button.getWidth();
        JButton back = new JButton(new ImageIcon(ImageLoader.back_button.getScaledInstance(
                back_width,back_height,Image.SCALE_DEFAULT
        )));

        back.setBorder(BorderFactory.createEmptyBorder());
        back.setContentAreaFilled(false);
        current_panel.add(back,BorderLayout.SOUTH);
        current_panel.setVisible(true);
        MainFrame.mainframe.setVisible(true);

        back.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   close();
               }
           }
        );
    }

    public void close() {
        current_panel.removeAll();
        MainFrame.mainframe.remove(current_panel);
        MainFrame.mainframe.setContentPane(old);
    }
}

