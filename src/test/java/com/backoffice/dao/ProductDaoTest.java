package com.backoffice.dao;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.models.ImageModel;
import com.backoffice.dao.models.ProductAttributeModel;
import com.backoffice.dao.models.ProductModel;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class ProductDaoTest {

	private static final double DOUBLE_COMPARISON_DELTA = 0.01;
	private static final String PRODUCT_DESCRIPTION = "this is product description";
	private static final double PRODUCT_PRICE = 5.5;
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
		Assert.assertEquals("wrong image count", 2, CollectionUtils.size(product.getAttributes()));
	}

	private ProductModel createProduct() {
		final ProductModel product = new ProductModel();
		product.setSku(UUID.randomUUID().toString());
		product.setDescription(PRODUCT_DESCRIPTION);
		product.setPrice(PRODUCT_PRICE);
		final ArrayList<ImageModel> imageList = createImages(product);

		final ArrayList<ProductAttributeModel> attributeList = createAttributes(product);
		product.setImages(imageList);
		product.setAttributes(attributeList);
		return product;
	}

	private ArrayList<ProductAttributeModel> createAttributes(final ProductModel product) {
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

	private ArrayList<ImageModel> createImages(final ProductModel product) {
		final ImageModel image1 = new ImageModel();
		image1.setImageName("image1Name");
		image1.setProduct(product);

		final ImageModel image2 = new ImageModel();
		image2.setImageName("image2name");
		image2.setProduct(product);

		final ArrayList<ImageModel> imageList = Lists.newArrayList(image1, image2);
		return imageList;
	}
}
