package com.goat.chapter009.action;


import com.goat.chapter009.gui.FormTestDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.http.util.TextUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class DistinctAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        // 获取IDEA当前活动编辑器
        if (null == mEditor) return;
        SelectionModel model = mEditor.getSelectionModel();
        // 获取当前活动编辑器中 选中的文本内容
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText))  return;

        String[] strings = StringUtils.tokenizeToStringArray(selectedText, "\n");
        Set<String> sets = new LinkedHashSet<>(Arrays.asList(strings));

//        DisplayUtil.showPopupBalloon(mEditor,strings.toString(),1000);

        FormTestDialog formTestDialog = new FormTestDialog(e.getProject());
        formTestDialog.setResizable(true); //是否允许用户通过拖拽的方式扩大或缩小你的表单框，我这里定义为true，表示允许
        formTestDialog.show();
    }
}


