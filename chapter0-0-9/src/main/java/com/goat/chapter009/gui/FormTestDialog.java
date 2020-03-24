package com.goat.chapter009.gui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Administrator on 2020/3/20.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---11:27
 */
public class FormTestDialog extends DialogWrapper {

    private FormTestSwing formTestSwing = new FormTestSwing();

    public FormTestDialog(@Nullable Project project) {
        super(project);
        setTitle("山羊工具箱"); // 设置会话框标题
        init(); //触发一下init方法，否则swing样式将无法展示在会话框
    }

    @Override
    protected JComponent createNorthPanel() {
        return formTestSwing.initNorth();
    }

    @Override
    protected JComponent createSouthPanel() {
        return formTestSwing.initSouth(this);
    }

    @Override
    protected JComponent createCenterPanel() {
        return formTestSwing.initCenter();
    }
}