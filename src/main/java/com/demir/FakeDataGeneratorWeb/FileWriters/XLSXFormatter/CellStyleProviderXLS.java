package com.demir.FakeDataGeneratorWeb.FileWriters.XLSXFormatter;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.util.Map;

public class CellStyleProviderXLS {
    public static XSSFCellStyle getStyle1(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        java.awt.Color color = new java.awt.Color(180, 198, 231);
        byte[] rgb = new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()};
        Map<String, String> arg1 = null; // you can set this to an empty map if you wish
        XSSFColor xssfColor = new XSSFColor(rgb, (IndexedColorMap) arg1);
        style.setFillForegroundColor(xssfColor);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.WHITE.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.WHITE.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.WHITE.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.WHITE.getIndex());
        return style;
    }

    public static XSSFCellStyle getStyle2(XSSFWorkbook workbook) {
        // Create a cell style with the desired formatting options
        XSSFCellStyle style2 = workbook.createCellStyle();
        java.awt.Color color = new java.awt.Color(217, 225, 242);
        byte[] rgb = new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()};
        Map<String, String> arg1 = null;
        XSSFColor xssfColor = new XSSFColor(rgb, (IndexedColorMap) arg1);
        style2.setFillForegroundColor(xssfColor);
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setTopBorderColor(IndexedColors.WHITE.getIndex());
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBottomBorderColor(IndexedColors.WHITE.getIndex());
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setLeftBorderColor(IndexedColors.WHITE.getIndex());
        style2.setBorderRight(BorderStyle.THIN);
        style2.setRightBorderColor(IndexedColors.WHITE.getIndex());
        return style2;
    }

    public static XSSFCellStyle getStyle3(XSSFWorkbook workbook) {
        // Create a cell style with the desired formatting options
        XSSFCellStyle style3 = workbook.createCellStyle();
        java.awt.Color color = new java.awt.Color(0, 0, 255);
        byte[] rgb = new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()};
        Map<String, String> arg1 = null; // you can set this to an empty map if you wish
        XSSFColor xssfColor = new XSSFColor(rgb, (IndexedColorMap) arg1);
        style3.setFillForegroundColor(xssfColor);
        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style3.setBorderTop(BorderStyle.THIN);
        style3.setTopBorderColor(IndexedColors.WHITE.getIndex());
        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBottomBorderColor(IndexedColors.WHITE.getIndex());
        style3.setBorderLeft(BorderStyle.THIN);
        style3.setLeftBorderColor(IndexedColors.WHITE.getIndex());
        style3.setBorderRight(BorderStyle.THIN);
        style3.setRightBorderColor(IndexedColors.WHITE.getIndex());
        XSSFFont font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        style3.setFont(font);
        return style3;
    }



}
