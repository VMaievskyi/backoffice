package com.backoffice.dao;

import static com.backoffice.dao.TestDataCreator.AVAILABLE_QUANTITY;
import static com.backoffice.dao.TestDataCreator.DOUBLE_COMPARISON_DELTA;
import static com.backoffice.dao.TestDataCreator.PRODUCT_DESCRIPTION;
import static com.backoffice.dao.TestDataCreator.PRODUCT_PRICE;
import static com.backoffice.dao.TestDataCreator.RESERVED_QUANTITY;
import static com.backoffice.dao.TestDataCreator.createProduct;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.models.ProductModel;
import com.google.common.collect.Iterables;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class ProductDaoTest {

	@Autowired
	private ProductDao testInstance;

	@Test
	public void shouldInsertProductWithAllFields() {
		final ProductModel product = createProduct();
		testInstance.save(product);
	}

	@Test
	public void shouldReadProductWithItsFields() {
		final ProductModel productToSave = createProduct();
		testInstance.save(productToSave);
		final Iterable<ProductModel> allProducts = testInstance.findAll();
		final ProductModel product = Iterables.getFirst(allProducts, null);
		Assert.assertNotNull("No product found", product);
		Assert.assertEquals("wrong DESCRIPTION", PRODUCT_DESCRIPTION, product.getDescription());
		Assert.assertNotNull(product.getSku());
		Assert.assertEquals("wrong price", PRODUCT_PRICE, product.getPrice(), DOUBLE_COMPARISON_DELTA);

		Assert.assertEquals("wrong image count", 2, CollectionUtils.size(product.getImages()));
		Assert.assertEquals("wrong attribute count", 2, CollectionUtils.size(product.getAttributes()));
		Assert.assertEquals("wrong stock available", AVAILABLE_QUANTITY, product.getStock().getAvailabeQuantity(),
				0.01);
		Assert.assertEquals("wrong stock available", RESERVED_QUANTITY, product.getStock().getReservedQuantity(), 0.01);
		Assert.assertNotNull("Stock id not set", product.getStock().getId());
	}

}
