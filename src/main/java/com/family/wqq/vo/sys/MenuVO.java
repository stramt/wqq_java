package com.family.wqq.vo.sys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName MenuVO
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/31 17:52
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    private Long id;
    private String name;
    private Long parentId;
    private String component;
    private String redirect;
    private Meta meta;
    private String path;
}

