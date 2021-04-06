package com.myport.mapper;

import com.myport.domain.AssetVo;
import com.myport.domain.InvestmentVo;

import java.util.List;

public interface InvestmentMapper {

    public void insert(InvestmentVo investment);

    public List<InvestmentVo> getList(InvestmentVo investment);

    public InvestmentVo select(InvestmentVo investment);

    public Long selectKey(InvestmentVo investment);

    public int update(InvestmentVo investment);

    public int delete(InvestmentVo investment);

}
