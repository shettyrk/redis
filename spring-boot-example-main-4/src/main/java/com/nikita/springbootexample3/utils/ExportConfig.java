package com.nikita.springbootexample3.utils;

import com.nikita.springbootexample3.DTO.UserActionLogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportConfig {
    private int sheetIndex;
    private int startRow;
    private Class dataClass;
    private List<CellConfig> cellExportConfigList;
    public static final ExportConfig customerExport;
    static {
        customerExport= new ExportConfig();
        customerExport.setSheetIndex(0);
        customerExport.setStartRow(1);
        customerExport.setDataClass(UserActionLogDTO.class);
        List<CellConfig> userActionLogs = new ArrayList<>();
        userActionLogs.add(new CellConfig(0,"id"));
        userActionLogs.add(new CellConfig(1,"email"));
        userActionLogs.add(new CellConfig(2,"type"));
        userActionLogs.add(new CellConfig(3,"action"));
        userActionLogs.add(new CellConfig(4,"created_timestamp"));
        userActionLogs.add(new CellConfig(5,"message"));
        userActionLogs.add(new CellConfig(6,"status"));



    }
}
