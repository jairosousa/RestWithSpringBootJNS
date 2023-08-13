package br.com.jnsdevs.RestWithSpringBootJNS.unittests.mapper;


import br.com.jnsdevs.RestWithSpringBootJNS.data.vo.v1.PersonVO;
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
		PersonVO output = MMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("FirstNameTest0", output.getFirstName());
		assertEquals("LastNameTest0", output.getLastName());
		assertEquals("Adress Test0", output.getAddress());
		assertEquals("Male", output.getGender());
		
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person output = MMapper.parseObject(inputObject.mockVO(), Person.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("FirstNameTest0", output.getFirstName());
		assertEquals("LastNameTest0", output.getLastName());
		assertEquals("Adress Test0", output.getAddress());
		assertEquals("Male", output.getGender());
		
	}
	
	@Test
	public void parseListEntityToListVoTest() {
		List<Person> outpuList = MMapper.parseListObject(inputObject.mockVOList(), Person.class);
		
		Person otputZero = outpuList.get(0);
		assertEquals(Long.valueOf(0L), otputZero.getId());
		assertEquals("FirstNameTest0", otputZero.getFirstName());
		assertEquals("LastNameTest0", otputZero.getLastName());
		assertEquals("Adress Test0", otputZero.getAddress());
		assertEquals("Male", otputZero.getGender());
		
		Person otputSeven= outpuList.get(7);
		assertEquals(Long.valueOf(7L), otputSeven.getId());
		assertEquals("FirstNameTest7", otputSeven.getFirstName());
		assertEquals("LastNameTest7", otputSeven.getLastName());
		assertEquals("Adress Test7", otputSeven.getAddress());
		assertEquals("Female", otputSeven.getGender());
	}
	
	@Test
	public void parseListVOToListEntityTest() {
		List<PersonVO> outpuList = MMapper.parseListObject(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO otputZero = outpuList.get(0);
		assertEquals(Long.valueOf(0L), otputZero.getId());
		assertEquals("FirstNameTest0", otputZero.getFirstName());
		assertEquals("LastNameTest0", otputZero.getLastName());
		assertEquals("Adress Test0", otputZero.getAddress());
		assertEquals("Male", otputZero.getGender());
		
		PersonVO otputSeven= outpuList.get(7);
		assertEquals(Long.valueOf(7L), otputSeven.getId());
		assertEquals("FirstNameTest7", otputSeven.getFirstName());
		assertEquals("LastNameTest7", otputSeven.getLastName());
		assertEquals("Adress Test7", otputSeven.getAddress());
		assertEquals("Female", otputSeven.getGender());
	}
}
