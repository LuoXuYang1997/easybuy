package com.scce.utils;

import com.scce.pojo.EasybuyEmployee;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

public class EmployeeExcelUtil {
    /**
     * 封装Excel的集合
     *
     * @param list
     * @param wb
     * @param headers
     * @throws Exception
     */
    int rowIndex = 0;
    public static void fillExcelData(List list, Workbook wb, String[] headers) throws Exception {
        int rowIndex = 0;
        Sheet sheet = wb.createSheet();
        /*
         * 设定合并单元格区域范围
         * 	firstRow  0-based
         * 	lastRow   0-based
         * 	firstCol  0-based
         * 	lastCol   0-based
         */
       /* CellRangeAddress cra=new CellRangeAddress(0, 2, 3, 6);
        //在sheet里增加合并单元格
        sheet.addMergedRegion(cra);*/
        Row row = sheet.createRow(rowIndex++);
        for (int i = 0; i < headers.length; i++) {
            row.createCell(i).setCellValue(headers[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

            EasybuyEmployee easybuyEmployee = (EasybuyEmployee) list.get(i);
            row = sheet.createRow(rowIndex++);
            //String headers[] = {"员工编号", "员工名", "密码", "真实姓名", "性别", "生日时间", "身份证号", "电话号码", "地址"};

            createCell(wb, row, (short) 0, (short) 2, (short) 1).setCellValue(easybuyEmployee.getEmployeeid());
            createCell(wb, row, (short) 1, (short) 2, (short) 1).setCellValue(easybuyEmployee.getEmployeename());

            createCell(wb, row, (short) 2, (short) 2, (short) 1).setCellValue(easybuyEmployee.getPassword());
            createCell(wb, row, (short) 3, (short) 2, (short) 1).setCellValue(easybuyEmployee.getRealname());
            createCell(wb, row, (short) 4, (short) 2, (short) 1).setCellValue(easybuyEmployee.getSex());
            CellStyle cellStyle = wb.createCellStyle();
            //设置日期格式
            CreationHelper creationHelper = wb.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
            Cell cell = row.createCell(5);
            cell.setCellValue(new HSSFRichTextString(" Align  it")); //设置值
            cellStyle.setAlignment(HorizontalAlignment.CENTER); //设置水平方向的对其方式
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); //设置垂直方法的对齐方式
            cell.setCellValue(easybuyEmployee.getBirthday());
            cell.setCellStyle(cellStyle);


            createCell(wb, row, (short)6, (short) 2, (short) 1).setCellValue(easybuyEmployee.getIdcard());

            createCell(wb, row, (short) 7, (short) 2, (short) 1).setCellValue(easybuyEmployee.getPhone());

            createCell(wb, row, (short) 8, (short) 2, (short) 1).setCellValue(easybuyEmployee.getAddress());

        }
    }

    private static Cell createCell(Workbook wb, Row row, short colunm, short halign, short valign) {
        Cell cell = row.createCell(colunm);
        cell.setCellValue(new HSSFRichTextString(" Align  it")); //设置值
        CellStyle cellStyle = wb.createCellStyle();  //设置样式
        cellStyle.setAlignment(HorizontalAlignment.forInt(halign)); //设置水平方向的对其方式
        cellStyle.setVerticalAlignment(VerticalAlignment.forInt(valign)); //设置垂直方法的对齐方式
        cell.setCellStyle(cellStyle); //设置单元格样式

        return cell;
    }


}
