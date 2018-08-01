package com.kangyonggan.as.service;

import com.kangyonggan.as.constants.App;
import com.kangyonggan.common.Params;
import com.kangyonggan.common.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author kangyonggan
 * @since 8/1/18
 */
@Service
@Log4j2
public class ArticleService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 搜索文章
     *
     * @param params
     * @return
     */
    public Response searchArticles(Params params) {
        return restTemplate.getForObject("http://" + App.ARTICLE.getCode() + "/article", Response.class, params.getQuery());
    }

}
