package com.backoffice.dao;

import static com.backoffice.dao.TestDataCreator.ADDITIONAL_IINFO;
import static com.backoffice.dao.TestDataCreator.APT;
import static com.backoffice.dao.TestDataCreator.BUILDING;
import static com.backoffice.dao.TestDataCreator.DOOR_CODE;
import static com.backoffice.dao.TestDataCreator.KYIV;
import static com.backoffice.dao.TestDataCreator.LAST_NAME;
import static com.backoffice.dao.TestDataCreator.NAME;
import static com.backoffice.dao.TestDataCreator.POSTAL_CODE;
import static com.backoffice.dao.TestDataCreator.STREAT;
import static com.backoffice.dao.TestDataCreator.UKRAINE;
import static com.backoffice.dao.TestDataCreator.createCustomer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.models.AddressModel;
import com.backoffice.dao.models.UserModel;
import com.google.common.collect.Iterables;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class CustomerDaoTest {

	@Autowired
	private CustomerDao testInstance;

	@Before
	public void setUp() {

	}

	@Test
	public void shouldLoadCustomer() {
		testInstance.save(createCustomer());
		final Iterable<UserModel> customers = testInstance.findAll();
		Assert.assertFalse("no customer found", Iterables.isEmpty(customers));
		checkCustomer(Iterables.getLast(customers));
	}

	private void checkCustomer(final UserModel savedCustomer) {
		Assert.assertEquals("wrong name", NAME, savedCustomer.getFirstName());
		Assert.assertEquals("wrong last name", LAST_NAME, savedCustomer.getLastName());
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

}
