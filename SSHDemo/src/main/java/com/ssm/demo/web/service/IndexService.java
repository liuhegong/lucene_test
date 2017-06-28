package com.ssm.demo.web.service;

import com.ssm.demo.core.dto.DocDto;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Describe: sevice接口
 * Author: ouym
 * Created Date: 2016/11/30.
 */
public interface IndexService {

    /**
     * 构建索引，传入参数：文档路径
     * @param path
     * @return
     */
    public boolean createIndex(String path);


    /**
     * 通过query查询索引
     * @param query
     */
    public List<DocDto> searchIndex(String query, Model model);
}
