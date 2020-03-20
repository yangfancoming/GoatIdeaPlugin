package com.goat.chapter008;

import com.goat.chapter008.model.MyResult;
import com.goat.chapter008.util.ConfigUtil;
import com.goat.chapter008.util.DisplayUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.http.util.TextUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class HelloIDEA extends AnAction {

    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        // 获取 百度翻译 API 配置信息
        Properties properties = ConfigUtil.getProperties("config.properties");
        String from = properties.getProperty("from");
        String to = properties.getProperty("to");
        String appid = properties.getProperty("appid");
        String salt = String.valueOf(System.currentTimeMillis());
        String sign = properties.getProperty("sign");

        RestTemplate restTemplate = new RestTemplate(); // 不能放在类外面！！！
        // 获取IDEA当前活动编辑器
        final Editor mEditor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) return;
        SelectionModel model = mEditor.getSelectionModel();
        // 获取当前活动编辑器中 选中的文本内容
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText))  return;

        // 发起请求获取翻译结果
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("q", selectedText);
        requestBody.add("from",from);
        requestBody.add("to", to);
        requestBody.add("appid", appid);
        requestBody.add("salt", salt);
        String src = appid + selectedText + salt + sign;
        requestBody.add("sign", DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8)));
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<MyResult> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, requestEntity, MyResult.class);
        MyResult body = responseEntity.getBody();
        // 显示翻译结果
        DisplayUtil.showPopupBalloon(mEditor,body.getTrans_result().get(0).getDst(),2000);
    }

}
