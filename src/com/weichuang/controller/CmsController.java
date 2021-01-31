package com.weichuang.controller;

import com.weichuang.pojo.CmsCompany;
import com.weichuang.pojo.CmsRecruit;
import com.weichuang.service.CmsCompanyService;
import com.weichuang.service.CmsRecruiterService;
import com.weichuang.vo.CommonResult;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.ConcurrentModificationException;
import java.util.List;

@Controller
public class CmsController {



    @Autowired
    CmsCompanyService cmsCompanyService;

    @Autowired
    CmsRecruiterService cmsRecruiterService;


    @RequestMapping(value = "/getCompanyInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> getCompanyInfo(Long id){
         CmsCompany cmsCompany =  cmsCompanyService.getcompanyInfoById(id);
        CommonResult<Object> commonResult = new CommonResult<>("成功",cmsCompany);
        return commonResult;
    }

    @RequestMapping(value = "/getRecruitDetail.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> getRecruitDtail(Long id){
       CmsRecruit cmsRecruit = cmsRecruiterService.getRecruitDetail(id);
       CommonResult<Object> commonResult = new CommonResult<>(200,"成功",cmsRecruit);
       return commonResult;
    }

    @RequestMapping(value = "/getRecruitList.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> getRectuitList(@RequestParam(value = "isClose",required = true) int isClose,
                                                 @RequestParam (value = "pageNum",required = false,defaultValue = "4" )int pageNum,
                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5" )int pageSize
                                              ){
        List<CmsRecruit> cmsRecruitList = cmsRecruiterService.getRecruitList(isClose,pageNum,pageSize);
        CommonResult<Object> commonResult = new CommonResult<>(200,"成功",cmsRecruitList);
        return commonResult;
    }

    @RequestMapping(value = "/getInformation.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> getInfomation(int  type){
        List<CmsRecruit> cmsRecruits = cmsRecruiterService.getInfomation(type);
        CommonResult<Object> commonResult = new CommonResult<>(200,"成功",cmsRecruits);
        return commonResult;
    }

    @RequestMapping(value = "/releaseRecruit.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> releaseRecruit(CmsRecruit cmsRecruit){
      int rows = cmsRecruiterService.releasrRecruit(cmsRecruit);
        CommonResult<Object> commonResult;
      if(rows > 0){
          commonResult = new CommonResult<>(200,"更新成功",cmsRecruit);
      }else commonResult = new CommonResult<>(400,"更新失败",0);
     return commonResult;
    }

}
