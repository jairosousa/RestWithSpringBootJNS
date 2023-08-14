package br.com.jnsdevs.RestWithSpringBootJNS.unittests.mapper;


import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
import br.com.jnsdevs.RestWithSpringBootJNS.mapper.DozerMapper;
import br.com.jnsdevs.RestWithSpringBootJNS.mapper.MMapper;
import br.com.jnsdevs.RestWithSpringBootJNS.model.Person;
import br.com.jnsdevs.RestWithSpringBootJNS.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozerConverterTest {

	MockPerson inputObject;

	@BeforeEach
	public void setup() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVoTest() {
		PersonVO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
		assertEquals(Long.valueOf(0L), output.getKey());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());
		
	}
	
	@Test
	public void parseListEntityToListVoTest() {
		List<Person> outpuList = DozerMapper.parseListObject(inputObject.mockVOList(), Person.class);
		
		Person otputZero = outpuList.get(0);
		assertEquals(Long.valueOf(0L), otputZero.getId());
		assertEquals("First Name Test0", otputZero.getFirstName());
		assertEquals("Last Name Test0", otputZero.getLastName());
		assertEquals("Address Test0", otputZero.getAddress());
		assertEquals("Male", otputZero.getGender());
		
		Person otputSeven= outpuList.get(7);
		assertEquals(Long.valueOf(7L), otputSeven.getId());
		assertEquals("First Name Test7", otputSeven.getFirstName());
		assertEquals("Last Name Test7", otputSeven.getLastName());
		assertEquals("Address Test7", otputSeven.getAddress());
		assertEquals("Female", otputSeven.getGender());
	}
	
	@Test
	public void parseListVOToListEntityTest() {
		List<PersonVO> outpuList = DozerMapper.parseListObject(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO otputZero = outpuList.get(0);
		assertEquals(Long.valueOf(0L), otputZero.getKey());
		assertEquals("First Name Test0", otputZero.getFirstName());
		assertEquals("Last Name Test0", otputZero.getLastName());
		assertEquals("Address Test0", otputZero.getAddress());
		assertEquals("Male", otputZero.getGender());
		
		PersonVO otputSeven= outpuList.get(7);
		assertEquals(Long.valueOf(7L), otputSeven.getKey());
		assertEquals("First Name Test7", otputSeven.getFirstName());
		assertEquals("Last Name Test7", otputSeven.getLastName());
		assertEquals("Address Test7", otputSeven.getAddress());
		assertEquals("Female", otputSeven.getGender());
	}
}
