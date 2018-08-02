package com.kangyonggan.as.service;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.as.constants.App;
import com.kangyonggan.np.model.Novel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@FeignClient(App.NOVEL_PLATFORM)
public interface NovelService {

    /**
     * 获取小说列表
     *
     * @param query
     * @return
     */
    @GetMapping("novel")
    PageInfo<Novel> list(@RequestParam("query") Map<String, Object> query);

    /**
     * 获取小说
     *
     * @param code
     * @return
     */
    @GetMapping("novel/{code}")
    Novel get(@PathVariable("code") Integer code);

    /**
     * 拉取小说最新章节
     *
     * @param code
     */
    @GetMapping("novel/{code}/pull")
    void pull(@PathVariable("code") Integer code);
}
