package cn.thght.swj.workbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.thght.swj.workbook.utils.CommonConst;

@SpringBootApplication
public class MyJavaWarehouseFirstBootApplication {

    public static void main(String[] args) {
        if (args.length != 0) {
            CommonConst.designationFileName = args[0];
        }
        SpringApplication.run(MyJavaWarehouseFirstBootApplication.class, args);
    }
}
