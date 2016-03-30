package com.backoffice.dao;

import static com.backoffice.dao.TestDataCreator.EMAIL;
import static com.backoffice.dao.TestDataCreator.HOME_PHONE;
import static com.backoffice.dao.TestDataCreator.MOBILE_PHONE;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.models.ContactInfoModel;
import com.backoffice.dao.models.OrderModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class OrderDaoTest {
	@Autowired
	private OrderDao testInstance;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;

	@Test
	public void shouldCreateOrder() {
		final OrderModel order = TestDataCreator.createOrder();
		customerDao.save(order.getUser());
		productDao.save(order.getOrderEntries().get(0).getProduct());
		testInstance.save(order);
		Assert.assertNotNull("id not set", order.getId());
		Assert.assertNotNull("order code not generated", order.getOrderCode());

		final ContactInfoModel contactInfo = order.getDeliveryInfo().getContactInfo();
		Assert.assertEquals("wrong last", EMAIL, contactInfo.getEmail());
		Assert.assertEquals("wrong home phone", HOME_PHONE, contactInfo.getHomePhone());
		Assert.assertEquals("wrong  mobile phone", MOBILE_PHONE, contactInfo.getMobilePhone());
	}

}
