package com.goat.chapter008;

import com.goat.chapter008.util.DisplayUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.http.util.TextUtils;

public class HelloIDEA extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        // 获取IDEA当前活动编辑器
        final Editor mEditor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) return;
        SelectionModel model = mEditor.getSelectionModel();
        // 获取当前活动编辑器中 选中的文本内容
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText))  return;
        System.out.println(selectedText);
        DisplayUtil.showPopupBalloon(mEditor,selectedText,2000);
    }


}
