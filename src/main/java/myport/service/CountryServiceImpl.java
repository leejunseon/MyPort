package myport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myport.domain.CountryVo;
import myport.domain.UserVo;
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
		// TODO Auto-generated method stub
		return mapper.addCountry(vo);
	}

}
