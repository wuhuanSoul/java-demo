package com.systec.main;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * Created by wh on 10/11/2017.
 *
 * 注意：将jacob.dll文件放到java_home/bin目录下，若不行，尝试放到window/system32目录下
 * 打开"开始-运行-输入regsvr32 dll"，回车即可解决。
 */
public class ConvertPDF {

    private static final int wdFormatPDF = 17;
    private static final int xlTypePDF = 0;
    private static final int ppSaveAsPDF = 32;

    public static String getFileSufix(String fileName){
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(splitIndex + 1);
    }
    private static int convertPDF(String inputFile, String pdfFile){
        String kind = getFileSufix(inputFile);
        File file = new File(inputFile);
        if(!file.exists()){
            return -2; //文件不存在
        }
        if(kind.equals("pdf")){
            return -3; //原文件就是PDF文件
        }
        if(kind.equals("doc") || kind.equals("docx") || kind.equals("txt")){
            return ConvertPDF.wordPDF(inputFile, pdfFile);
        }else if(kind.equals("ppt") || kind.equals("pptx")){
            return ConvertPDF.pptPDF(inputFile, pdfFile);
        }else if(kind.equals("xls") || kind.equals("xlsx")){
            return ConvertPDF.xlsPDF(inputFile, pdfFile);
        }else{
            return -4;
        }
    }



    private static int wordPDF(String inputFile, String pdfFile) {
        ActiveXComponent app = new ActiveXComponent("KWPS.Application");
        System.out.println("开始将Word转化为PDF...");
        long date = new Date().getTime();
        //设置Word不可见
        app.setProperty("Visible", new Variant(false));
        //禁用宏
        app.setProperty("AutomationSecurity", new Variant(3));
        //获得Word中所有打开的文档，返回document对象
        Dispatch docs = app.getProperty("Document").toDispatch();
//        调用Document对象中Open方法打开文档，并返回打开的文档对象Document
        Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true).toDispatch();
        /**
         *调用Document对象的SaveAs方法，将文档保存为pdf格式
         *
         * Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF)
         *word保存为pdf格式宏，值为17
         * */

        Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
        System.out.println(doc);
        //关闭文档
        long date2 = new Date().getTime();
        int time = (int)((date2 - date)/1000);
        Dispatch.call(doc, "Close", false);
        //关闭Word应用程序
        app.invoke("Quit", 0);
        return time;
    }

    private static int pptPDF(String inputFile, String pdfFile) {
        ComThread.InitSTA(true);
        ActiveXComponent app = new ActiveXComponent("KWPP.application");

        System.out.println("开始将PPT转化为PDF...");
        long date = new Date().getTime();
        Dispatch ppts = app.getProperty("Presentations").toDispatch();
        Dispatch ppt = Dispatch.call(ppts, "Open", inputFile, true, false).toDispatch();
        Dispatch.invoke(ppt, "SavaAs", Dispatch.Method, new Object[]{
                pdfFile, new Variant(ppSaveAsPDF)}, new int[1]);
        System.out.println("PPT");
        Dispatch.call(ppt, "Close");
        long date2 = new Date().getTime();
        int time = (int) ((date2 - date)/1000);
        app.invoke("Quit");
        return time;
    }

    private static int xlsPDF(String inputFile, String pdfFile) {
        ComThread.InitSTA(true);
        ActiveXComponent app = new ActiveXComponent("KET.Application");
        System.out.println("开始将Excel转化为PDF...");
        long date = new Date().getTime();
        app.setProperty("Visible", false);
        app.setProperty("AutomationSecurity", new Variant(3));
        Dispatch excels = app.getProperty("Workbooks").toDispatch();
        Dispatch excel = Dispatch
                .invoke(excels, "Open", Dispatch.Method,
                        new Object[] {inputFile, new Variant(false), new Variant(false)}, new int[9]).toDispatch();
        Dispatch.invoke(excel,"ExportAsFixedFormat", Dispatch.Method, new Object[]{new Variant(0), pdfFile, new Variant(xlTypePDF)}, new int[1]);
        long date2 = new Date().getTime();
        int time = (int) ((date2 - date)/1000);
        Dispatch.call(excel, "Close", new Variant(false));
        if (app != null){
            app.invoke("Quit", new Variant[]{});
            app = null;
        }
        ComThread.Release();
        return time;
    }

    @Test
    public void testConvertPDF(){
        int time = convertPDF("D://纪要上传测试文件.xlsx", "D://纪要上传测试文件.pdf");
        if (time == -4){
            System.out.println("转化失败，未知错误...");
        }else if(time == -3){
            System.out.println("原文件就是PDF文件，无需转化");
        }else if(time == -2){
            System.out.println("转化失败，文件不存在...");
        }else if(time == -1){
            System.out.println("转化失败，请重新尝试...");
        }else if(time < -4){
            System.out.println("转化失败，请重新尝试...");
        }else {
            System.out.println("转化成功，用时 ：" + time + "s...");
        }

    }

}
