package com.shanhai.springbootinittemplate;

import com.shanhai.springbootinittemplate.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootInitTemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test01(){
        List<Map<Integer, String>> maps = ExcelUtils.readExcelData(new File("C:\\Users\\25654\\Documents\\我的POPO\\iphone非活跃用户id_phone.csv"));
        System.out.println();
    }

}
