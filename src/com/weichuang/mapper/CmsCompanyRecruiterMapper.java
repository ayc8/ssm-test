package com.weichuang.mapper;

import com.weichuang.pojo.CmsCompanyRecruiter;
import com.weichuang.pojo.CmsCompanyRecruiterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCompanyRecruiterMapper {
    long countByExample(CmsCompanyRecruiterExample example);

    int deleteByExample(CmsCompanyRecruiterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsCompanyRecruiter record);

    int insertSelective(CmsCompanyRecruiter record);

    List<CmsCompanyRecruiter> selectByExampleWithBLOBs(CmsCompanyRecruiterExample example);

    List<CmsCompanyRecruiter> selectByExample(CmsCompanyRecruiterExample example);

    CmsCompanyRecruiter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsCompanyRecruiter record, @Param("example") CmsCompanyRecruiterExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsCompanyRecruiter record, @Param("example") CmsCompanyRecruiterExample example);

    int updateByExample(@Param("record") CmsCompanyRecruiter record, @Param("example") CmsCompanyRecruiterExample example);

    int updateByPrimaryKeySelective(CmsCompanyRecruiter record);

    int updateByPrimaryKeyWithBLOBs(CmsCompanyRecruiter record);

    int updateByPrimaryKey(CmsCompanyRecruiter record);
}