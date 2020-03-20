# 加入spring后报错 Could not initialize class org.springframework.http.HttpLogging
    
    compile 'commons-httpclient:commons-httpclient:3.1'
    compile group: 'org.springframework', name: 'spring-web', version: '5.1.9.RELEASE'
    原因： 以上两个依赖的中的 日志冲突 干掉 commons-httpclient 依赖即可
    