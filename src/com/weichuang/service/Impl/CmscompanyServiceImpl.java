package com.weichuang.service.Impl;

import com.weichuang.mapper.CmsCompanyMapper;
import com.weichuang.pojo.CmsCompany;
import com.weichuang.service.CmsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmscompanyServiceImpl implements CmsCompanyService {
    @Autowired
    CmsCompanyMapper cmsCompanyMapper;
    @Override
    public CmsCompany getcompanyInfoById(Long id) {
        return cmsCompanyMapper.selectByPrimaryKey(id);
    }
}
