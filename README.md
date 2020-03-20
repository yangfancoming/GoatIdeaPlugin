# 
    1. File --> new --> Project--> Intellij PlatForm Plugin-->Next-->填好项目名OK
    
    2. 新建工程后在src下建个java文件 HelloIDEA.java
        public class HelloIDEA extends AnAction {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                // 弹窗显示消息
                Messages.showMessageDialog("Hello world", 
                "ShuoGG Say", Messages.getInformationIcon());
            }
        }
    
    3. plugin.xml在META-INF目录下
        name为插件名, action用定义插件的input和output, 等实现效果再回过头来看这参数就很清楚了
        
     4. 打包插件  工具栏--> Build -->  Prepare Plugin Module‘xxxx’for Deloyment  后会 生成一个 jar包
     
     5. 从本地磁盘安装 插件
     
     
     6. 到window菜单的第一栏就会看到HelloIDEA一项, 其实就是对应之前xml下action的group-id="WindowMenu" anchor="first"
                 <add-to-group group-id="WindowMenu" anchor="first"/>
     
#  配置gradle （实测第二步可以不用）
     1、使用 本地  Use local gradle distribution  F:/Package/Java Environment/gradle-5.0
     
     2、更改gradle下载的依赖包存放的位置（ 不改会把包都下载到C盘。windows下才需要这样设置，其他系统忽略）
     在系统环境变量里面配置一个GRADLE_USER_HOME
     值为：F:\Package\Java Environment\gradlecache
     
     
     3、切换到较快的源
     在GRADLE_USER_HOME指定的目录下新建一个init.gradle的文件
     
     4、将SDK包放置对应的本地仓库目录（你的网络很快，忽略这一条）
     gradle下载的依赖包在${GRADLE_USER_HOME}\caches\modules-2\files-2.1目录下
     我的目录在  F:\Package\Java Environment\gradle-5.0\caches\modules-2\files-2.1\com.jetbrains.intellij.idea\ideaIC\2019.1.1
     将下载后的ideaIC-2018.2.5.zip和ideaIC-2018.2.5-sources.jar文件拷贝到其中某个目录下。构建的时候.zip文件会自动解压。\
     若是让gradle 自动构建项目的话 会将 zip和jar  下载到
     F:\Package\Java Environment\gradle-5.0\caches\modules-2\files-2.1\com.jetbrains.intellij.idea\ideaIC\2019.1.1\90389b2ac6180b73c5ab128cf3b1d9f768b7395    ideaIC-2019.1.1.zip    490M
     F:\Package\Java Environment\gradle-5.0\caches\modules-2\files-2.1\com.jetbrains.intellij.idea\ideaIC\2019.1.1\db5b7b92cc9589863a7f7c506e0d7bf3ae29d680   ideaIC-2019.1.1-sources.jar    78M
     下载地址
     https://cache-redirector.jetbrains.com/www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/2019.1.1/ideaIC-2019.1.1.zip    490M
     https://cache-redirector.jetbrains.com/www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/2019.1.1/ideaIC-2019.1.1-sources.jar    78M
     
     这两个下载好之后 其他的就没那么大了，下载就没那么慢了
     
     建议在 F:\Package\Java Environment\gradle-5.0  下新建一个init.gradle的文件



# 
    在src/main/下面新建java目录，会自动被设为source root (蓝色目录)，并创建自己的包路径。比如com.free.helloworld。
     
     
# 基于gradle 插件开发  多模块环境搭建
    1. 先创建一个基本的gradle  java环境的父工程 （创建父工程是只能打钩java 不能打钩 IntelliJ Platform plugins）
    2. 删除父工程的src目录，再父工程下 右键新建Model 创建子工程同时 打钩java和IntelliJ Platform plugins
    3. 在子工程目录中 写好demo后，再右侧gradle工具中 查找 子目录chapter0-0-8依赖  
        依次打开   chapter0-0-8 ---> Tasks ---> intellij ---> runIde  调试插件
        依次打开   chapter0-0-8 ---> Tasks ---> intellij ---> buildPlugin  打包插件
        
        
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     