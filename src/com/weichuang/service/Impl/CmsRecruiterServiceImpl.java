package com.weichuang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.weichuang.mapper.CmsRecruitMapper;
import com.weichuang.pojo.CmsCompanyRecruiter;
import com.weichuang.pojo.CmsRecruit;
import com.weichuang.pojo.CmsRecruitExample;
import com.weichuang.service.CmsRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsRecruiterServiceImpl implements CmsRecruiterService{
    @Autowired
    CmsRecruitMapper cmsRecruitMapper;
    @Override
    public CmsRecruit getRecruitDetail(Long id) {
        return cmsRecruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CmsRecruit> getRecruitList(int isClose,int pageNum,int pageSize) {
        CmsRecruitExample cmsRecruitExample = new CmsRecruitExample();
        cmsRecruitExample.createCriteria().andIsCloseEqualTo(isClose);
        List<CmsRecruit> cmsRecruitList = cmsRecruitMapper.selectByExample(cmsRecruitExample);
        PageHelper.startPage(pageNum,pageSize);
        return cmsRecruitList;
    }

    @Override
    public List<CmsRecruit> getInfomation(int type) {
        CmsRecruitExample cmsRecruitExample = new CmsRecruitExample();
        cmsRecruitExample.createCriteria().andTypeEqualTo(type);
       List<CmsRecruit> cmsRecruits= cmsRecruitMapper.selectByExample(cmsRecruitExample);
        return cmsRecruits;
    }

    @Override
    public int releasrRecruit(CmsRecruit cmsRecruit) {
        return cmsRecruitMapper.insert(cmsRecruit);
    }
}
