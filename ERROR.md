

# 解决Gradle编译时出现： 编码GBK的不可映射字符

    单纯地在IDEA 的setting里设置file encoding中的三个 utf-8  是没有用的
    还要在 build.gradle文件中加入一行
    [compileJava, compileTestJava]*.options*.encoding = 'UTF-8'
