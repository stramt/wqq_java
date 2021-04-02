package com.family.wqq.vo.sys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Meta
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/31 17:59
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Meta {
    private String icon;
    private String title;
    private Boolean show;
}
