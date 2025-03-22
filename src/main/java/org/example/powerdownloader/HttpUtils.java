package org.example.powerdownloader;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.io.InputStream;

/**
 * TODO
 *
 * @author zhaohaonan
 * @since 2025/3/20
 */
public class HttpUtils {

    public static InputStream download(String url) {
        HttpResponse response = HttpRequest.post(url)
                .header("User-Agent", "Mozilla")
                .execute();
        return response.bodyStream();
    }

    public static String getFileName(String url) {
        String fullFileName = StrUtil.subAfter(url, "/", true);
        return StrUtil.subBefore(fullFileName, ".", true);
    }

    public static void main(String[] args) {
        System.out.println(getFileName("https://www.baidu.com"));
    }


}