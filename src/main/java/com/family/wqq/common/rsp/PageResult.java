package com.family.wqq.common.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @description: 通用分页返回实体
 * @author: hdp
 * @create: 2018/11/17 11:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult<T> {
    private Long total; //总条数
    private int totalPage; //总页数
    private int currentPage;//当前页
    private int pageSize;//每页显示数
    private int start;
    private int end;

    private List<T> items; //当前页数据
    public List<T> getCurrPageList(List<T> list, Integer currentPage, Integer pageSize) {
        int begin = (currentPage - 1) * pageSize;
        int size = list.size();
        int end = begin + pageSize;
        if (size <= end) {
            end = size;
        }
        return list.subList(begin, end);

    }
}
