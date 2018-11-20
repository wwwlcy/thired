package org.imooc.controller.content;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.*;
import org.imooc.bean.Ad;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    AdService adService;



    @RequestMapping("/remove")
    public String remove(Ad ad){
        //得到id根据id做删除
        System.out.println(ad);
        return "";
    }

    @RequestMapping("/modifyInit")
    public String getAd(Ad ad){
        //得到id 做更新时的回显
        System.out.println(ad);
        return "";
    }
    @RequestMapping("/modify")
    public String doUpdate(Ad ad){
        //得到更新的对象，准备更新
        return "";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String  toAdList(Model model){
       List<Ad> list= adService.selectAllAd();
        String jsonString = JSON.toJSONString(list);
        model.addAttribute("list",list);

        return "/content/adList";
    }
    @ResponseBody
    @RequestMapping("/downExcel")
    public String downExcel(){
        List<Ad> list= adService.selectAllAd();
        dodownExcel(list);

        return "success";
    }

    private void dodownExcel(List<Ad> list){

            FileOutputStream out = null;
            try {
                out = new FileOutputStream("D:/基本信息报表.xls");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // create a new workbook
           HSSFWorkbook wb = new HSSFWorkbook();
                // create a new sheet
           HSSFSheet sheet = wb.createSheet();
            HSSFRow row = sheet.createRow((short)0);//建立新行

            row.createCell(0).setCellValue("编号");//设置cell的整数类型的值
            row.createCell(1).setCellValue("标题");//设置cell浮点类型的值
            row.createCell(2).setCellValue("连接地址");//设置cell字符类型的值
        row.createCell(3).setCellValue("图片地址");//设置cell字符类型的值
            row.createCell(4).setCellValue("重量");//设置cell布尔类型的值
        //row.createCell(4).setCellValue(ad.getWeight());
        for (int i = 0; i <list.size() ; i++) {
            Ad ad = list.get(i);
            row = sheet.createRow((short)i+1);//建立新行

            row.createCell(0).setCellValue(ad.getId());//设置cell的整数类型的值
            row.createCell(1).setCellValue(ad.getTitle());//设置cell浮点类型的值
            row.createCell(2).setCellValue(ad.getLink());//设置cell字符类型的值
            row.createCell(3).setCellValue(ad.getImgFileName());//设置cell布尔类型的值
            row.createCell(4).setCellValue(ad.getWeight());

        }
                sheet.setColumnWidth(2, 4000);
                sheet.setColumnWidth(3, 4000);

                //3.output
                sheet.setDisplayGridlines(false);
                sheet.setPrintGridlines(false);
                 HSSFPrintSetup printSetup = sheet.getPrintSetup();
                //A4纸
                 printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
        try {
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
