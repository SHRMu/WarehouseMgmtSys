package FrameDesign;

import Util.MgmtSysUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class JFrameTemplate extends JFrame {
    private String title;
    private String topLabel;
    private Box vBox;
    private Font font;

    public JFrameTemplate(String title, String topLabel, JPanel centrePanel) throws HeadlessException {
        initFrame(title);
        this.setTopLabel(topLabel);
        this.add(centrePanel, BorderLayout.CENTER);
        this.setDate();
    }

    public JFrameTemplate(String title, String topLabel, JPanel centrePanel, Font font) throws HeadlessException {
        initFrame(title,font);
        this.setTopLabel(topLabel);
        this.add(centrePanel,BorderLayout.CENTER);
    }

    // mainFrame
    public void initFrame(String title){
        this.setTitle(title);
        this.setSize(1024,768);
        //handle the position by OS!
        this.setLocationByPlatform(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set default font size
        MgmtSysUtil.setUIFont(new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,28));
    }

    //operationFrame
    public void initFrame(String title, Font font){
        this.setTitle(title);
        this.setSize(1024,768);
        //handle the position by OS!
        this.setLocationByPlatform(true);
        this.setLayout(new BorderLayout());
        //set default font size
        MgmtSysUtil.setUIFont(new javax.swing.plaf.FontUIResource(font));
    }

    //set top content Label
    public void setTopLabel(String topLabel){
        Panel topPanel = new Panel();
        topPanel.add(new JLabel(topLabel));
        this.add(topPanel, BorderLayout.NORTH);
    }

    //set BorderLayout bottom Date Label
    public void setDate(){
        Panel datePanel = new Panel();
        Date currentDate = new Date();
        datePanel.add(new JLabel(currentDate.toString()));
        this.add(datePanel, BorderLayout.SOUTH);
    }
}
