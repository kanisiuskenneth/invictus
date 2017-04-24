package view;

import controller.ImageLoader;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sylviajuliana on 24-Apr-17.
 */
public class CreditsView {
  JPanel creditsPanel;

  public CreditsView() {
    creditsPanel = new JPanel();
    creditsPanel.setLayout(new BorderLayout());
    creditsPanel.setSize(MainFrame.width, MainFrame.height);
    creditsPanel.setBackground(MainFrame.DARK_GRAY);
    MainFrame.mainframe.setContentPane(creditsPanel);
    int head_width = MainFrame.widthToPx(60);
    int head_height = head_width * ImageLoader.creditsBanner.getHeight() /
            ImageLoader.creditsBanner.getWidth();
    JLabel head_banner = new JLabel(new ImageIcon(
            ImageLoader.creditsBanner.getScaledInstance(head_width, head_height, Image.SCALE_DEFAULT)));
    creditsPanel.add(head_banner, BorderLayout.NORTH);
    JPanel credits = new JPanel();
    creditsPanel.add(credits, BorderLayout.CENTER);
    credits.setLayout(new GridLayout(6, 1));
    credits.setBackground(MainFrame.DARK_GRAY);
    credits.setVisible(true);
    head_banner.setVisible(true);

    JLabel namaKelompok = new JLabel("Kelompok 11 - Invictus", SwingConstants.CENTER);
    namaKelompok.setFont(new Font("Helvetica", Font.PLAIN, 50));
    namaKelompok.setForeground(Color.YELLOW);
    JLabel nama1 = new JLabel("Kanisius Kenneth H. - 13515008", SwingConstants.CENTER);
    nama1.setFont(new Font("Helvetica", Font.PLAIN, 50));
    nama1.setForeground(Color.WHITE);
    JLabel nama2 = new JLabel("Andika Kusuma - 13515033", SwingConstants.CENTER);
    nama2.setFont(new Font("Helvetica", Font.PLAIN, 50));
    nama2.setForeground(Color.WHITE);
    JLabel nama3 = new JLabel("Kezia Suhendra - 13515063", SwingConstants.CENTER);
    nama3.setFont(new Font("Helvetica", Font.PLAIN, 50));
    nama3.setForeground(Color.WHITE);
    JLabel nama4 = new JLabel("Sylvia Juliana - 13515070", SwingConstants.CENTER);
    nama4.setFont(new Font("Helvetica", Font.PLAIN, 50));
    nama4.setForeground(Color.WHITE);

    credits.add(namaKelompok);
    credits.add(nama1);
    credits.add(nama2);
    credits.add(nama3);
    credits.add(nama4);

    int back_width = MainFrame.widthToPx(30);
    int back_height = back_width * ImageLoader.back_button.getHeight() / ImageLoader.back_button.getWidth();
    JButton back = new JButton(new ImageIcon(ImageLoader.back_button.getScaledInstance(
            back_width, back_height, Image.SCALE_DEFAULT
    )));

    back.setBorder(new EmptyBorder(0,0,30,0));
    back.setContentAreaFilled(false);
    creditsPanel.add(back, BorderLayout.SOUTH);
    creditsPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);

    back.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
         Menu mainmenu = new Menu();
       }
     }
    );
  }
}
