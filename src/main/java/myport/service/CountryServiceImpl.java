package myport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.vo.CountryVo;
import myport.domain.vo.UserVo;
import myport.mapper.CountryMapper;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{
	
	private CountryMapper mapper;

	@Override
	public List<CountryVo> retrieveCountries(UserVo vo) {
		return mapper.retrieveCountries(vo);
	}

	@Override
	public int addCountry(CountryVo vo) {
		return mapper.addCountry(vo);
	}

	@Override
	public int modifyCountries(List<CountryVo> voList) {
		int updatedRow = 0;
		for(CountryVo paramVo : voList) {
			updatedRow += mapper.modifyCountry(paramVo);
		}
		return updatedRow;
	}

	@Override
	public int deleteCountries(List<CountryVo> voList) {
		int deletedRow = 0;
		for(CountryVo paramVo : voList) {
			deletedRow += mapper.deleteCountry(paramVo);
		}
		return deletedRow;
	}

}
