package BtnActionListener;

import FrameDesign.JFrameTemplate;
import Util.MgmtSysUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JPanel centrePanel = new JPanel();
        JFrame operationFrame = new JFrameTemplate("Operation Interface",
                                                    "Please enter the test information as follow",
                                                        centrePanel, MgmtSysUtil.frameFont);
        operationFrame.setVisible(true);
    }
}
