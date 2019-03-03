package FrameDesign;

import Util.MgmtSysUtil;
import BtnActionListener.InBoundAction;

import javax.swing.*;
import java.awt.*;
import BtnActionListener.*;

public class MgmtSysMain{

    public static void main(String[] args) {
        // centre Content Panel
        JPanel centreContentPanel = new JPanel();
        Box hBoxInComing = Box.createHorizontalBox();
        JButton inComingBtn = new JButton("  Inbound  ");
        inComingBtn.setFont(MgmtSysUtil.btnFont);
        hBoxInComing.add(inComingBtn);

        Box hBoxOperation = Box.createHorizontalBox();
        JButton operationBtn = new JButton("Operation");
        operationBtn.setFont(MgmtSysUtil.btnFont);
        hBoxOperation.add(operationBtn);

        Box hBoxOutGoing = Box.createHorizontalBox();
        JButton outGoingBtn = new JButton("Outbound");
        outGoingBtn.setFont(MgmtSysUtil.btnFont);
        hBoxOutGoing.add(outGoingBtn);

        //vBox
        Box vBox = Box.createVerticalBox();
        //padding space between two buttonBox
        Dimension padding = new Dimension(0,75);
        //top padding space should be bigger
        vBox.add(Box.createRigidArea(new Dimension(0,100)));
        vBox.add(hBoxInComing);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxOperation);
        vBox.add(Box.createRigidArea(padding));
        vBox.add(hBoxOutGoing);
        centreContentPanel.add(vBox);

        //action listener
        inComingBtn.addActionListener(new InBoundAction());
        operationBtn.addActionListener(new OperationAction());
        outGoingBtn.addActionListener(new OutBoundAction());

        JFrame mainFrame = new JFrameTemplate("Warehouse Management System",
                                                "Welcome to Warehouse Management System",
                                                centreContentPanel );
        mainFrame.setVisible(true);
    }
}
