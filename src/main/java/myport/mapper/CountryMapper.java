package myport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myport.domain.vo.CountryVo;
import myport.domain.vo.UserVo;

@Mapper
public interface CountryMapper {
	
	public List<CountryVo> retrieveCountries(UserVo vo);
	
	public int addCountry(CountryVo vo);
	
	public int modifyCountry(CountryVo vo);
	
	public int deleteCountry(CountryVo vo);

}
