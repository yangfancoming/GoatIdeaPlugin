package com.goat.chapter008.action;

import com.goat.chapter008.FormTestDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by Administrator on 2020/3/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---11:35
 */
public class FromAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        FormTestDialog formTestDialog = new FormTestDialog(e.getProject());
        formTestDialog.setResizable(true); //是否允许用户通过拖拽的方式扩大或缩小你的表单框，我这里定义为true，表示允许
        formTestDialog.show();
    }
}