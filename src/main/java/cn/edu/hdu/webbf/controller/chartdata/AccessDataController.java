/*
 * File Name: LifeService.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年11月2日

 * Modifier: Pi Chen
 * Modify Date: 2016年11月2日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.controller.chartdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hdu.webbf.common.base.BaseController;

/**
 *
 * 图表数据：访问来源
 * @author    Pi Chen
 * @version   webbf V1.0.0, 2016年11月2日
 * @see
 * @since     webbf V1.0.0
 */
@Controller
@RequestMapping(value = "/ad")
public class AccessDataController extends BaseController
{

    /**
     * 曲线图数据模拟 ，一般是从数据库获取的，这里直接模拟产生
     * @return
     */
    @RequestMapping(value = "/getAdData", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAdData()
    {
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> emailList = new ArrayList<Integer>();
            List<Integer> allianceList = new ArrayList<Integer>();
            List<Integer> vedioList = new ArrayList<Integer>();
            List<Integer> directList = new ArrayList<Integer>();
            List<Integer> searchList = new ArrayList<Integer>();
            List<String> xTitleList = new ArrayList<String>();
            Random r = new Random();
            //模拟产生数据，实际应用中请调用service获取
            for(int i = 0; i < 60; i++){
                emailList.add(r.nextInt(50));
                allianceList.add(r.nextInt(50));
                vedioList.add(r.nextInt(50));
                directList.add(r.nextInt(50));
                searchList.add(r.nextInt(50));
                xTitleList.add(i + "m");
            }
            map.put("emailList", emailList);
            map.put("allianceList", allianceList);
            map.put("vedioList", vedioList);
            map.put("directList", directList);
            map.put("searchList", searchList);
            map.put("xTitleList", xTitleList);
            return gson.toJson(map);
        }
        catch (Exception e)
        {
            logger.error(e.toString(), e);
        }
        return gson.toJson(FAILD);
    }
}
