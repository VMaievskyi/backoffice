package com.backoffice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.backoffice.dao.models.AddressModel;
import com.backoffice.dao.models.ContactInfoModel;
import com.backoffice.dao.models.CustomerModel;
import com.backoffice.dao.models.DeliveryInfo;
import com.backoffice.dao.models.ImageModel;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.OrderModel;
import com.backoffice.dao.models.OrderStatus;
import com.backoffice.dao.models.ProductAttributeModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.dao.models.StockModel;
import com.backoffice.dao.models.delivery.CourierDeliveryModel;
import com.backoffice.dao.models.delivery.DeliveryTypeModel;
import com.google.common.collect.Lists;

public class TestDataCreator {
	public static final int QUANTITY = 10;
	public static final double TOTAL_PRICE = 100d;
	public static final String LAST_NAME = "lastName";
	public static final String NAME = "name";
	public static final String MOBILE_PHONE = "+38097000000";
	public static final String HOME_PHONE = "31119878";
	public static final String EMAIL = "email";
	public static final String ADDITIONAL_IINFO = "additional Iinfo";
	public static final String APT = "11";
	public static final String BUILDING = "16/2";
	public static final String STREAT = "streat 1";
	public static final String DOOR_CODE = "13";
	public static final String POSTAL_CODE = "3111";
	public static final String KYIV = "kyiv";
	public static final String UKRAINE = "Ukraine";

	public static final long RESERVED_QUANTITY = 5L;
	public static final long AVAILABLE_QUANTITY = 10L;
	public static final String PRODUCT_DESCRIPTION = "this is product description";
	public static final double PRODUCT_PRICE = 5.5;
	public static final double DOUBLE_COMPARISON_DELTA = 0.01;

	public static CustomerModel createCustomer() {
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

	public static ContactInfoModel createContactInfo() {
		final ContactInfoModel contactInfo = new ContactInfoModel();
		contactInfo.setEmail(EMAIL);
		contactInfo.setHomePhone(HOME_PHONE);
		contactInfo.setMobilePhone(MOBILE_PHONE);
		return contactInfo;
	}

	public static AddressModel createAddress() {
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

	public static ProductModel createProduct() {
		final ProductModel product = new ProductModel();
		product.setSku(UUID.randomUUID().toString());
		product.setName("name");
		product.setDescription(PRODUCT_DESCRIPTION);
		product.setPrice(PRODUCT_PRICE);
		final ArrayList<ImageModel> imageList = createImages(product);

		final ArrayList<ProductAttributeModel> attributeList = createAttributes(product);
		product.setImages(imageList);
		product.setAttributes(attributeList);

		final StockModel stock = initStock();

		product.setStock(stock);
		return product;
	}

	public static StockModel initStock() {
		final StockModel stock = new StockModel();
		stock.setAvailabeQuantity(AVAILABLE_QUANTITY);
		stock.setReservedQuantity(RESERVED_QUANTITY);
		return stock;
	}

	public static ArrayList<ProductAttributeModel> createAttributes(final ProductModel product) {
		final ProductAttributeModel attribute1 = new ProductAttributeModel();
		attribute1.setName("attribute1name");
		attribute1.setValue("attribute1value");
		attribute1.setProduct(product);

		final ProductAttributeModel attribute2 = new ProductAttributeModel();
		attribute2.setName("attribute2name");
		attribute2.setValue("attribute2value");
		attribute2.setProduct(product);
		final ArrayList<ProductAttributeModel> attributeList = Lists.newArrayList(attribute1, attribute2);
		return attributeList;
	}

	public static ArrayList<ImageModel> createImages(final ProductModel product) {
		final ImageModel image1 = new ImageModel();
		image1.setImageName("image1Name");
		image1.setProduct(product);

		final ImageModel image2 = new ImageModel();
		image2.setImageName("image2name");
		image2.setProduct(product);

		final ArrayList<ImageModel> imageList = Lists.newArrayList(image1, image2);
		return imageList;
	}

	public static DeliveryInfo createDeliveryInfo() {
		final DeliveryInfo deliveryInfo = new DeliveryInfo();
		final DeliveryTypeModel type = new CourierDeliveryModel();
		type.setCost(100);
		type.setDeliveryAddress(createAddress());
		type.setTypeName("nova poshta");
		deliveryInfo.setDeliveryType(type);
		return deliveryInfo;
	}

	public static OrderModel createOrder() {
		final OrderModel order = new OrderModel();
		order.setCustomer(TestDataCreator.createCustomer());
		order.setDeliveryInfo(TestDataCreator.createDeliveryInfo());
		order.setOrderStatus(OrderStatus.CREATED);
		order.setTotalPrice(TOTAL_PRICE);
		final OrderEntryModel entry = createOrderEntry();
		order.setOrderEntries(Lists.newArrayList(entry));
		return order;
	}

	public static OrderEntryModel createOrderEntry() {
		final OrderEntryModel entry = new OrderEntryModel();
		entry.setProduct(createProduct());
		entry.setQuantity(QUANTITY);
		return entry;
	}

}
