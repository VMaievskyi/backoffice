package com.backoffice.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.models.AddressModel;
import com.backoffice.dao.models.ContactInfoModel;
import com.backoffice.dao.models.CustomerModel;
import com.google.common.collect.Iterables;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class CustomerDaoTest {

	private static final String LAST_NAME = "lastName";
	private static final String NAME = "name";
	private static final String MOBILE_PHONE = "+38097000000";
	private static final String HOME_PHONE = "31119878";
	private static final String EMAIL = "email";
	private static final String ADDITIONAL_IINFO = "additional Iinfo";
	private static final String APT = "11";
	private static final String BUILDING = "16/2";
	private static final String STREAT = "streat 1";
	private static final String DOOR_CODE = "13";
	private static final String POSTAL_CODE = "3111";
	private static final String KYIV = "kyiv";
	private static final String UKRAINE = "Ukraine";
	@Autowired
	private CustomerDao testInstance;

	@Before
	public void setUp() {

	}

	@Test
	public void shouldCreateCustomer() {
		final CustomerModel customer = createCustomer();

		testInstance.save(customer);
		Assert.assertNotNull("id not created", customer.getId());
	}

	@Test
	public void shouldLoadCustomer() {
		testInstance.save(createCustomer());
		final Iterable<CustomerModel> customers = testInstance.findAll();
		Assert.assertFalse("no customer found", Iterables.isEmpty(customers));
		checkCustomer(Iterables.getLast(customers));
	}

	private void checkCustomer(final CustomerModel savedCustomer) {
		Assert.assertEquals("wrong name", NAME, savedCustomer.getFirstName());
		Assert.assertEquals("wrong last name", LAST_NAME, savedCustomer.getLastName());
		final ContactInfoModel contactInfo = savedCustomer.getContactInfo();
		Assert.assertEquals("wrong last", EMAIL, contactInfo.getEmail());
		Assert.assertEquals("wrong home phone", HOME_PHONE, contactInfo.getHomePhone());
		Assert.assertEquals("wrong  mobile phone", MOBILE_PHONE, contactInfo.getMobilePhone());
		final AddressModel address = savedCustomer.getSavedAddress();
		Assert.assertEquals("wrong additional info", ADDITIONAL_IINFO, address.getAdditionalInfo());
		Assert.assertEquals("wrong apartment", APT, address.getAppartment());
		Assert.assertEquals("wrong building", BUILDING, address.getBuilding());
		Assert.assertEquals("wrong city", KYIV, address.getCity());
		Assert.assertEquals("wrong country", UKRAINE, address.getCountry());
		Assert.assertEquals("wrong  door code", DOOR_CODE, address.getDoorCode());
		Assert.assertEquals("wrong postal code", POSTAL_CODE, address.getPostalCode());
		Assert.assertEquals("wrong ", STREAT, address.getStreet());
	}

	private CustomerModel createCustomer() {
		final AddressModel addressModel = createAddress();
		final ContactInfoModel contactInfo = createContactInfo();

		final CustomerModel customer = new CustomerModel();
		customer.setAnonimous(Boolean.TRUE);
		customer.setBirthDate(new Date());
		customer.setContactInfo(contactInfo);
		customer.setFirstName(NAME);
		customer.setGender(Boolean.TRUE);
		customer.setLastName(LAST_NAME);
		customer.setSavedAddress(addressModel);
		return customer;
	}

	private ContactInfoModel createContactInfo() {
		final ContactInfoModel contactInfo = new ContactInfoModel();
		contactInfo.setEmail(EMAIL);
		contactInfo.setHomePhone(HOME_PHONE);
		contactInfo.setMobilePhone(MOBILE_PHONE);
		return contactInfo;
	}

	private AddressModel createAddress() {
		final AddressModel address = new AddressModel();
		address.setCountry(UKRAINE);
		address.setCity(KYIV);
		address.setPostalCode(POSTAL_CODE);
		address.setDoorCode(DOOR_CODE);
		address.setStreet(STREAT);
		address.setBuilding(BUILDING);
		address.setAppartment(APT);
		address.setAdditionalInfo(ADDITIONAL_IINFO);
		return address;
	}

}
