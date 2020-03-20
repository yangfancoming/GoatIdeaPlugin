package com.goat.chapter008.action;

import com.intellij.designer.clipboard.SimpleTransferable;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.util.PsiTreeUtil;

import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/20---11:35
 */
public class Demo1Action extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
//        test1(e);
//        test2(e);
        test3(e);
    }

    public void test1(AnActionEvent e){
        //获取当前在操作的工程上下文
        Project project = e.getData(PlatformDataKeys.PROJECT);
        //获取当前操作的类文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前类文件的路径
        String classPath = psiFile.getVirtualFile().getPath();
        String title = "Hello World!";
        //显示对话框
        Messages.showMessageDialog(project, classPath, title, Messages.getInformationIcon());
    }

    // 判断当前光标选择的元素是什么
    public void test2(AnActionEvent e){
        Project project = e.getData(PlatformDataKeys.PROJECT);
        //获取当前事件触发时，光标所在的元素
        PsiElement psiElement = e.getData(LangDataKeys.PSI_ELEMENT);
        //如果光标选择的不是类，弹出对话框提醒
        if (psiElement == null || !(psiElement instanceof PsiClass)) {
            Messages.showMessageDialog(project, "Please focus on a class", "Generate Failed", null);
            return;
        }
    }

    //  获取当前类文件的所有类对象 (一个类文件中可能会有内部类，所以读取的时候返回的是一个列表)
    public void test3(AnActionEvent e){
        Project project = e.getData(PlatformDataKeys.PROJECT);
        PsiElement psiElement = e.getData(LangDataKeys.PSI_ELEMENT);
        List<PsiClass> classes = getClasses(psiElement);
        Messages.showMessageDialog(project, String.valueOf(classes.size()), "Generate Failed", null);
    }

    public static List<PsiClass> getClasses(PsiElement element) {
        List<PsiClass> elements = new ArrayList<>();
        List<PsiClass> classElements = PsiTreeUtil.getChildrenOfTypeAsList(element, PsiClass.class);
        elements.addAll(classElements);
        for (PsiClass classElement : classElements) {
            //这里用了递归的方式获取内部类
            elements.addAll(getClasses(classElement));
        }
        return elements;
    }

    // 格式化代码
    public static void reformatJavaFile(PsiElement theElement) {
        CodeStyleManager codeStyleManager = CodeStyleManager.getInstance(theElement.getProject());
        try {
            codeStyleManager.reformat(theElement);
        } catch (Exception e) { }
    }

    // 使用粘贴板
    public void tst(){
        CopyPasteManager.getInstance().setContents(new SimpleTransferable("", DataFlavor.allHtmlFlavor));

    }
}