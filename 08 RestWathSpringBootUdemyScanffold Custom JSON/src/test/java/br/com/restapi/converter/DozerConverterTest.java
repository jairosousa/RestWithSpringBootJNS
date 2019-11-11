package br.com.restapi.converter;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.restapi.converter.mocks.MockPerson;
import br.com.restapi.data.model.Person;
import br.com.restapi.data.vo.v1.PersonVO;

public class DozerConverterTest {

	MockPerson inputObject;
	
	@Before
	public void setup() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVoTest() {
		PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("FirstNameTest0", output.getFirstName());
		assertEquals("LastNameTest0", output.getLastName());
		assertEquals("Adress Test0", output.getAddress());
		assertEquals("Male", output.getGender());
		
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("FirstNameTest0", output.getFirstName());
		assertEquals("LastNameTest0", output.getLastName());
		assertEquals("Adress Test0", output.getAddress());
		assertEquals("Male", output.getGender());
		
	}
	
	@Test
	public void parseListEntityToListVoTest() {
		List<Person> outpuList = DozerConverter.parseListObject(inputObject.mockVOList(), Person.class);
		
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
		List<PersonVO> outpuList = DozerConverter.parseListObject(inputObject.mockEntityList(), PersonVO.class);
		
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
