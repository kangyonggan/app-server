package com.kangyonggan.as.service;

import com.kangyonggan.common.Params;
import com.kangyonggan.common.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Service
@Log4j2
public class ArticleService {

    @Value("${article.app.name}")
    private String serviceName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 搜索文章
     *
     * @param params
     * @return
     */
    public Response searchArticles(Params params) {
        return restTemplate.getForObject("http://" + serviceName + "/article", Response.class, params);
    }

}
