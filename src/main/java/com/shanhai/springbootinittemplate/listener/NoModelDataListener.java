package com.shanhai.springbootinittemplate.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author libo
 * @date 2023/4/21 11:30
 */
public class NoModelDataListener extends AnalysisEventListener<Map<Integer, String>> {

    @Getter
    private final List<Map<Integer, String>> result = new ArrayList<>();
    @Getter
    private final List<String> head = new ArrayList<>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        result.add(data);
    }

    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        for (Object o : headMap.keySet()) {
            head.add(headMap.get(o).toString());
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
