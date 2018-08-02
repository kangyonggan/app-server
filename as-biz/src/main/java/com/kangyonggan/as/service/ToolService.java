package com.kangyonggan.as.service;

import com.kangyonggan.common.Params;
import com.kangyonggan.common.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kangyonggan
 * @since 6/7/18
 */
public interface ToolService {
    /**
     * 预处理请求
     *
     * @param params
     * @param response
     */
    void preHandle(Params params, Response response);

    /**
     * 处理请求
     *
     * @param params
     * @param response
     * @param file
     * @return
     */
    void handle(Params params, Response response, MultipartFile file);
}
