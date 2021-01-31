package com.weichuang.service;

import com.weichuang.pojo.CmsCompanyRecruiter;
import com.weichuang.pojo.CmsRecruit;

import java.util.List;

public interface CmsRecruiterService {
    CmsRecruit getRecruitDetail(Long id);

    List<CmsRecruit> getRecruitList(int isClose,int pageNum,int pageSize);

   List<CmsRecruit> getInfomation(int  type);

    int releasrRecruit(CmsRecruit cmsRecruit);
}
