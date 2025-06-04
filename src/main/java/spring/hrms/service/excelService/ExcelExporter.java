package spring.hrms.service.excelService;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@Component
public class ExcelExporter {


    public static byte[] exportToExcel(List<List<String>> data, String sheetName) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                List<String> rowData = data.get(i);

                for (int j = 0; j < rowData.size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(rowData.get(j));
                }
            }

            if (!data.isEmpty()) {
                int columnCount = data.getFirst().size();
                for (int i = 0; i < columnCount; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                workbook.write(out);
                return out.toByteArray();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
