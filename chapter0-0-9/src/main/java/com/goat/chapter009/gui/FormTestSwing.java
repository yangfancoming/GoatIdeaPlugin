package com.goat.chapter009.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2020/3/20.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---11:31
 */
public class FormTestSwing {

    private JPanel north = new JPanel();
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();

    //为了让位于底部的按钮可以拿到组件内容，这里把表单组件做成类属性
    private JTextArea text1 = new JTextArea();
    private JTextArea text2 = new JTextArea();

    public JPanel initNorth() {
        return north;
    }

    public JPanel initCenter() {
        //定义表单的主体部分，放置到IDEA会话框的中央位置
        //一个简单的2行2列的表格布局
        center.setLayout(new GridLayout(2, 2,10,10));
        center.add(text1);
        center.add(text2);
        return center;
    }

    public JPanel initSouth(FormTestDialog formTestDialog) {
        //定义表单的提交按钮，放置到IDEA会话框的底部位置
        JButton submit = new JButton("提交");
        submit.setHorizontalAlignment(SwingConstants.CENTER); //水平居中
        submit.setVerticalAlignment(SwingConstants.CENTER); //垂直居中
        south.add(submit);
        //按钮事件绑定
        submit.addActionListener(e -> {
//            HelloIDEA.appid = appIdText.getText();
//            HelloIDEA.sign = signText.getText();
            formTestDialog.close(0,true);
        });
        return south;
    }
}
