package BtnActionListener;

import FrameDesign.JFrameTemplate;
import Util.MgmtSysUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutBoundAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {

        JPanel centrePanel = new JPanel();
        JFrame outBoundFrame = new JFrameTemplate("Outbound Interface",
                "waiting for adding",
                centrePanel, MgmtSysUtil.frameFont);
        outBoundFrame.setVisible(true);
    }
}
