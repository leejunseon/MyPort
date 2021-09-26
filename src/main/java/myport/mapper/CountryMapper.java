package myport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.CountryVo;
import myport.domain.UserVo;

@Mapper
public interface CountryMapper {
	
	public List<CountryVo> retrieveCountries(UserVo vo);
	
	public int addCountry(CountryVo vo);

}
