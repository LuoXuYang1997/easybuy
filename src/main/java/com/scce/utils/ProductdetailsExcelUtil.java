package com.scce.utils;

import com.scce.pojo.EasybuyOrder;
import com.scce.pojo.EasybuyProductdetails;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public class ProductdetailsExcelUtil {

    public static void fillExcelData(List list, Workbook wb, String[] headers) throws Exception {
        int rowIndex = 0;
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(rowIndex++);
        for (int i = 0; i < headers.length; i++) {
            row.createCell(i).setCellValue(headers[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            EasybuyProductdetails easybuyProductdetails = (EasybuyProductdetails) list.get(i);
            row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(easybuyProductdetails.getId());
            row.createCell(1).setCellValue(easybuyProductdetails.getRealname());
            row.createCell(2).setCellValue(easybuyProductdetails.getPhone());
            row.createCell(3).setCellValue(easybuyProductdetails.getAddress());
            row.createCell(4).setCellValue(easybuyProductdetails.getOrderId());
            row.createCell(5).setCellValue(easybuyProductdetails.getCreationdate());
            row.createCell(6).setCellValue(easybuyProductdetails.getProductdetails());
            row.createCell(7).setCellValue(easybuyProductdetails.getPrice());
            row.createCell(8).setCellValue(easybuyProductdetails.getProductnumber());
            row.createCell(9).setCellValue(easybuyProductdetails.getFreight());
            row.createCell(10).setCellValue(easybuyProductdetails.getTotalprice());
            row.createCell(11).setCellValue(easybuyProductdetails.getStatus());
        }

    }

    /**
     * 读取模板，将数据一个一个的放在模板中
     *
     * @param list
     * @param templateFileName
     * @return
     * @throws Exception
     */



    public static Workbook fillExcelDataWithTemplate(List list, String templateFileName) throws Exception {
        InputStream inp = OrderExcelUtil.class.getResourceAsStream("/com/java/template/" + templateFileName);
        POIFSFileSystem fs = new POIFSFileSystem(inp);
        Workbook wb = new HSSFWorkbook(fs);
        Sheet sheet = wb.getSheetAt(0);
        // 获取列数
        int cellNums = sheet.getRow(0).getLastCellNum();
        int rowIndex = 1;
		/*while(rs.next()){
			Row row=sheet.createRow(rowIndex++);
			for(int i=0;i<cellNums;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}*/
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowIndex++);
            for (int j = 0; j < cellNums; j++) {
                row.createCell(i).setCellValue(list.get(j).toString());
            }

        }
        return wb;
    }

    /**
     * @param hssfCell
     * @return
     */
    public static String formatCell(HSSFCell hssfCell) {
        if (hssfCell == null) {
            return "";
        } else {
            if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                return String.valueOf(hssfCell.getBooleanCellValue());
            } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                return String.valueOf(hssfCell.getNumericCellValue());
            } else {
                return String.valueOf(hssfCell.getStringCellValue());
            }
        }
    }

}
