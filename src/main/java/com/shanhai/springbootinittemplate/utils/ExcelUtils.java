package com.shanhai.springbootinittemplate.utils;

import com.alibaba.excel.EasyExcel;
import com.shanhai.springbootinittemplate.listener.NoModelDataListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * excel处理的工具类
 * @author libo
 * @date 2023/4/21 11:15
 */
public class ExcelUtils {
    public static List<Map<Integer, String>> readExcelData(String file) {
        return readExcelData(new File(file));
    }

    public static List<Map<Integer, String>> readExcelData(File file) {
        return readExcelDataBySheet(file, 0);
    }

    public static List<Map<Integer, String>> readExcelDataBySheet(File file, Integer sheetNo) {
        NoModelDataListener noModelDataListener = new NoModelDataListener();
        EasyExcel.read(file, noModelDataListener).sheet(sheetNo).doRead();
        return noModelDataListener.getResult();
    }

    public static List<String> readExcelHead(String file) {
        return readExcelHead(new File(file));
    }

    public static List<String> readExcelHead(File file) {
        NoModelDataListener noModelDataListener = new NoModelDataListener();
        EasyExcel.read(file, noModelDataListener).doReadAll();
        return noModelDataListener.getHead();
    }

    public static List<String> readExcelHeadBySheet(File file, Integer sheetNo) {
        NoModelDataListener noModelDataListener = new NoModelDataListener();
        EasyExcel.read(file, noModelDataListener).sheet(sheetNo).doRead();
        return noModelDataListener.getHead();
    }

    public static List<List<String>> genWriteHead(List<String> heads) {
        List<List<String>> headList = new ArrayList<>();
        for (String s : heads) {
            List<String> head = new ArrayList<>();
            head.add(s);
            headList.add(head);
        }
        return headList;
    }

    public static List<List<String>> genWriteData(List<Map<Integer, String>> data) {
        List<List<String>> result = new ArrayList<>();

        for (Map<Integer, String> datum : data) {

            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < datum.size(); i++) {
                list1.add(datum.get(i));
            }
            result.add(list1);
        }
        return result;
    }

    public static void writeExcel(File file, List<Map<Integer, String>> resultList, List<String> head) {
        EasyExcel.write(file).head(ExcelUtils.genWriteHead(head)).sheet("sheet1").doWrite(genWriteData(resultList));
    }

    public static void writeExcel(String file, List<Map<Integer, String>> resultList, List<String> head) {
        EasyExcel.write(new File(file)).head(ExcelUtils.genWriteHead(head)).sheet("sheet1").doWrite(genWriteData(resultList));
    }
}
