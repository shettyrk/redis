package com.nikita.springbootexample3.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Slf4j
@Component
public class FileFactory {
    public static final String PATH_TEMPLATE = "/home/ramakrishna.shetty/redis/saveExcelSheets";
    public static File createFile(String filename, Workbook workbook) throws Exception {
        workbook = new XSSFWorkbook();
        OutputStream out = new FileOutputStream(PATH_TEMPLATE+filename);
        workbook.write(out);
        return ResourceUtils.getFile(PATH_TEMPLATE+filename);
    }
}
