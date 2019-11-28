package com.tatelucky.yduts.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author tangsheng
 * @since 2019-08-06
 */
public class ExcelUtils {
    public ExcelUtils() {
    }

    public static File createExcel(String fileName, String sheetName, List<String> titleRow, List<List<String>> dataRows) {
        if (fileName == null) {
            fileName = "default";
        }

        if (sheetName == null) {
            sheetName = "default";
        }

        Workbook wb = new SXSSFWorkbook(1000);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);
        if (titleRow != null) {
            Row row = sheet.createRow(0);

            for (int i = 0; i < titleRow.size(); ++i) {
                Cell cell = row.createCell(i);
                cell.setCellValue((String) titleRow.get(i));
            }
        }

        if (dataRows != null) {
            for (int i = 0; i < dataRows.size(); ++i) {
                Row row = sheet.createRow(1 + i);
                List<String> data = (List) dataRows.get(i);
                if (data != null && data.size() != 0) {
                    for (int j = 0; j < data.size(); ++j) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue((String) data.get(j));
                    }
                }
            }
        }

        FileOutputStream fileOS = null;
        File file = null;

        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            fileOS = new FileOutputStream(file);
            wb.write(fileOS);
        } catch (FileNotFoundException var21) {
            var21.printStackTrace();
        } catch (IOException var22) {
            var22.printStackTrace();
        } finally {
            try {
                wb.close();
                fileOS.close();
            } catch (IOException var20) {
                var20.printStackTrace();
            }

        }

        return file;
    }

    public static void createExcelStream(OutputStream out, String sheetName, List<String> titleRow, List<List<String>> dataRows) {
        if (sheetName == null) {
            sheetName = "default";
        }

        Workbook wb = new SXSSFWorkbook(1000);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);
        if (titleRow != null) {
            Row row = sheet.createRow(0);

            for (int i = 0; i < titleRow.size(); ++i) {
                Cell cell = row.createCell(i);
                cell.setCellValue((String) titleRow.get(i));
            }
        }

        if (dataRows != null) {
            for (int i = 0; i < dataRows.size(); ++i) {
                Row row = sheet.createRow(1 + i);
                List<String> data = (List) dataRows.get(i);
                if (data != null && data.size() != 0) {
                    for (int j = 0; j < data.size(); ++j) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue((String) data.get(j));
                    }
                }
            }
        }

        try {
            wb.write(out);
        } catch (IOException var19) {
            var19.printStackTrace();
        } finally {
            try {
                wb.close();
            } catch (IOException var18) {
                var18.printStackTrace();
            }

        }

    }

    public static Workbook createWb() {
        return createWb((Integer) null);
    }

    public static Workbook createWb(Integer size) {
        if (size == null) {
            size = -1;
        }

        Workbook wb = new SXSSFWorkbook(size);
        return wb;
    }

    public static SXSSFSheet createSheet(Workbook wb, String sheetName, List<String> titleRow) {
        if (sheetName == null) {
            sheetName = "default";
        }

        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);
        if (titleRow != null) {
            Row row = sheet.createRow(0);

            for (int i = 0; i < titleRow.size(); ++i) {
                Cell cell = row.createCell(i);
                cell.setCellValue((String) titleRow.get(i));
            }
        }

        return sheet;
    }

    public static void continueWrite(SXSSFSheet sheet, List<List<String>> dataRows, int lastRow) {
        if (dataRows != null) {
            for (int i = 0; i < dataRows.size(); ++i) {
                Row row = sheet.createRow(1 + lastRow + i);
                List<String> data = (List) dataRows.get(i);
                if (data != null && data.size() != 0) {
                    for (int j = 0; j < data.size(); ++j) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue((String) data.get(j));
                    }
                }
            }
        }

    }

    public static void finish(OutputStream out, Workbook wb) {
        try {
            wb.write(out);
            wb.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}
