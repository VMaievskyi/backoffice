package com.backoffice.dao.models.promotion;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backoffice.dao.models.OrderEntryModel;

public class PromotionResultModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double discount;
	private List<OrderEntryModel> consumedEntries;

	public static PromotionResultModel create(final double discount, final List<OrderEntryModel> consumedEntries) {
		final PromotionResultModel result = new PromotionResultModel();
		result.setConsumedEntries(consumedEntries);
		result.setDiscount(discount);
		return result;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(final double discount) {
		this.discount = discount;
	}

	public List<OrderEntryModel> getConsumedEntries() {
		return consumedEntries;
	}

	public void setConsumedEntries(final List<OrderEntryModel> consumedEntries) {
		this.consumedEntries = consumedEntries;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
