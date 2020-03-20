package com.goat.chapter008;

import com.goat.chapter008.model.FormTestSwing;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Administrator on 2020/3/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---11:27
 */
public class FormTestDialog extends DialogWrapper {

    //swing样式类，定义在4.3.2
    private FormTestSwing formTestSwing = new FormTestSwing();

    // DialogWrapper没有默认的无参构造方法，所以需要重写构造方法，它提供了很多重载构造方法，
    // 这里使用传project类型参数的那个，通过Project对象可以获取当前IDEA内打开的项目的一些属性，
    // 比如项目名，项目路径等
    public FormTestDialog(@Nullable Project project) {
        super(project);
        setTitle("表单测试~~"); // 设置会话框标题
        init(); //触发一下init方法，否则swing样式将无法展示在会话框
    }

    // 重写下面的方法，返回一个自定义的swing样式，该样式会展示在会话框的最上方的位置
    // 用于表单的大标题
    @Override
    protected JComponent createNorthPanel() {
        return formTestSwing.initNorth(); //返回位于会话框north位置的swing样式
    }

    // 特别说明：不需要展示SouthPanel要重写返回null，否则IDEA将展示默认的"Cancel"和"OK"按钮
    // 重写下面的方法，返回一个自定义的swing样式，该样式会展示在会话框的最下方的位置
    // 用于 提交按钮  关闭按钮
    @Override
    protected JComponent createSouthPanel() {
        return formTestSwing.initSouth(this);
    }

    // 重写下面的方法，返回一个自定义的swing样式，该样式会展示在会话框的中央位置
    // 用于表单的主体部分
    @Override
    protected JComponent createCenterPanel() {
        //定义表单的主题，放置到IDEA会话框的中央位置
        return formTestSwing.initCenter();
    }
}