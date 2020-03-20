package com.goat.chapter001.util;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;

import java.awt.*;

/**
 * Created by Administrator on 2020/3/20.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---10:43
 */
public class DisplayUtil {

    /**
     * 执行操作
     * @param editor         激活窗口
     * @param result         显示内容
     * @param fadeOutTime    淡出时间
     */
    public static void showPopupBalloon(final Editor editor, final String result, int fadeOutTime) {
        ApplicationManager.getApplication().invokeLater(()->{
            JBPopupFactory factory = JBPopupFactory.getInstance();
            factory.createHtmlTextBalloonBuilder(result, null, new JBColor(new Color(186, 238, 186), new Color(73, 117, 73)), null)
                    .setFadeoutTime(fadeOutTime)
                    .createBalloon()
                    .show(factory.guessBestPopupLocation(editor), Balloon.Position.below);
        });
    }

    // 弹窗显示消息
    public void test(){
         Messages.showMessageDialog("content", "Goat Title", Messages.getInformationIcon());
    }
}
