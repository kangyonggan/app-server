package com.kangyonggan.as.controller;

import com.kangyonggan.ap.constants.ApplyStatus;
import com.kangyonggan.as.service.ArticleService;
import com.kangyonggan.common.Params;
import com.kangyonggan.common.Response;
import com.kangyonggan.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyonggan
 * @since 6/7/18
 */
@RestController
@RequestMapping("web/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     *
     * @return
     */
    @GetMapping
    public Response list() {
        Params params = getRequestParams();
        params.getQuery().put("applyStatus", ApplyStatus.COMPLETE.getCode());

        return articleService.searchArticles(params);
    }

}
