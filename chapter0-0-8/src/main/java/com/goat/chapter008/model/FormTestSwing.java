package com.goat.chapter008.model;

import com.goat.chapter008.FormTestDialog;
import com.goat.chapter008.action.HelloIDEA;

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
//    private JLabel r1 = new JLabel("输出：");
//    private JLabel r2 = new JLabel("NULL");
    private JLabel appId = new JLabel("AppId：");
    private JTextField appIdText = new JTextField();
    private JLabel sign = new JLabel("密钥：");
    private JTextField signText = new JTextField();

    public JPanel initNorth() {
        //定义表单的标题部分，放置到IDEA会话框的顶部位置
        JLabel title = new JLabel("百度翻译");
        title.setFont(new Font("微软雅黑", Font.PLAIN, 26)); //字体样式
        title.setHorizontalAlignment(SwingConstants.CENTER); //水平居中
        title.setVerticalAlignment(SwingConstants.CENTER); //垂直居中
        north.add(title);
        return north;
    }

    public JPanel initCenter() {
        //定义表单的主体部分，放置到IDEA会话框的中央位置
        //一个简单的2行2列的表格布局
        center.setLayout(new GridLayout(2, 2));
        //row1：按钮事件触发后将结果打印在这里
//        r1.setForeground(new Color(255, 47, 93)); //设置字体颜色
//        center.add(r1);
//        r2.setForeground(new Color(139, 181, 20)); //设置字体颜色
//        center.add(r2);
        //row2：
        center.add(appId);
        center.add(appIdText);
        center.add(sign);
        center.add(signText);
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
            HelloIDEA.appid = appIdText.getText();
            HelloIDEA.sign = signText.getText();
            formTestDialog.close(0,true);
        });
        return south;
    }
}
