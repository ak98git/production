package com.top.product.userinfo.dao;

import com.top.product.userinfo.entity.AccountInfoDO;
import com.top.product.userinfo.entity.AccountInfoDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountInfoDOMapper {
    long countByExample(AccountInfoDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountInfoDO record);

    int insertSelective(AccountInfoDO record);

    List<AccountInfoDO> selectByExampleWithBLOBs(AccountInfoDOExample example);

    List<AccountInfoDO> selectByExample(AccountInfoDOExample example);

    AccountInfoDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountInfoDO record, @Param("example") AccountInfoDOExample example);

    int updateByExampleWithBLOBs(@Param("record") AccountInfoDO record, @Param("example") AccountInfoDOExample example);

    int updateByExample(@Param("record") AccountInfoDO record, @Param("example") AccountInfoDOExample example);

    int updateByPrimaryKeySelective(AccountInfoDO record);

    int updateByPrimaryKeyWithBLOBs(AccountInfoDO record);

    int updateByPrimaryKey(AccountInfoDO record);
}