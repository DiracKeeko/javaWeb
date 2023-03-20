package com.keeko.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋节快乐");	// 新建一个窗体
        Panel panel = new Panel(null);	// 面板
        frame.setLayout(null);	// 设置窗体的布局

        frame.setBounds(300,300,500,500); // 窗体坐标和宽高
        frame.setBackground(new Color(0,0,255)); // 设置背景颜色

        panel.setBounds(50,50,300,300); // 面板坐标和宽高
        panel.setBackground(new Color(0,255,0)); // 设置背景颜色

        frame.add(panel); // 把面板添加到窗体上

        frame.setVisible(true); // 设置窗体为可见性

        // 监听事件，监听关闭事件
        frame.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("打开");
            }

            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("未激活");
            }

            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("关闭ing");
                // 有 0和 1
                System.exit(0);

            }

            public void windowClosed(WindowEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("关闭ed");
            }

            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("激活");
            }
        });
    }
}
