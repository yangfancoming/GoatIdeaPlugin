# 加入spring后报错 Could not initialize class org.springframework.http.HttpLogging
    
    compile 'commons-httpclient:commons-httpclient:3.1'
    compile group: 'org.springframework', name: 'spring-web', version: '5.1.9.RELEASE'
    原因： 以上两个依赖的中的 日志冲突 干掉 commons-httpclient 依赖即可
    
    
#  插件开发  依赖spring的情况
    可以使用 spring 读取 ***.properties文件的方式
    
    
#  引入自定义jar包 方法

    有时，我们需要的jar包不一定能在远程仓库中找到，这时我们需要加载本地的jar包。
    
    加载单独的jar包
    在项目根目录下(与src目录平齐)添加libs目录,将jar包仍进libs目录
    build.gradle配置如下: dependencies { compile files('lib/ojdbc-14.jar')}
    
    加载某个目录的jar包
    在自己的 Gradle 项目里建立一个名为 libs （这个名字可以自己定义，不一定非要叫这个名字）的文件夹，把自己本地的 jar 包拷贝到这个文件夹中。
    build.gradle配置如下: dependencies { compile fileTree(dir:'libs',include:['*.jar'])}
    
     compile fileTree(dir:'libs',include:['*.jar'])
    
    