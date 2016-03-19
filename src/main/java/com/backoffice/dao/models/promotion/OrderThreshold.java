package com.backoffice.dao.models.promotion;

import javax.persistence.Entity;

import org.apache.commons.lang.math.NumberUtils;

import com.backoffice.dao.models.OrderModel;

@Entity
public class OrderThreshold extends PromotionModel {

	private double requiredTreshold;
	private double percentageDiscount;
	private double absoluteDiscount;

	public double getRequiredTreshold() {
		return requiredTreshold;
	}

	public void setRequiredTreshold(final double requiredTreshold) {
		this.requiredTreshold = requiredTreshold;
	}

	public double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(final double percentageDiscount) {
		if ((absoluteDiscount != NumberUtils.DOUBLE_ZERO) && (percentageDiscount != NumberUtils.DOUBLE_ZERO)) {
			absoluteDiscount = NumberUtils.DOUBLE_ZERO;
		}
		this.percentageDiscount = percentageDiscount;
	}

	public double getAbsoluteDiscount() {
		return absoluteDiscount;
	}

	public void setAbsoluteDiscount(final double absoluteDiscount) {
		if ((percentageDiscount != NumberUtils.DOUBLE_ZERO) && (absoluteDiscount != NumberUtils.DOUBLE_ZERO)) {
			percentageDiscount = NumberUtils.DOUBLE_ZERO;
		}
		this.absoluteDiscount = absoluteDiscount;
	}

	@Override
	protected PromotionResultModel apply(final OrderModel order) {
		PromotionResultModel result = null;
		if ((absoluteDiscount == 0.0) && (percentageDiscount == 0.0)) {
			return result;
		}
		if (NumberUtils.compare(order.getTotalPrice(), getRequiredTreshold()) >= NumberUtils.DOUBLE_ZERO) {

			double appliedDiscount = NumberUtils.DOUBLE_ZERO;

			if (percentageDiscount != NumberUtils.DOUBLE_ZERO) {
				appliedDiscount = (order.getTotalPrice() * percentageDiscount) / 100;
			}
			if (absoluteDiscount != NumberUtils.DOUBLE_ZERO) {
				appliedDiscount = absoluteDiscount;
			}

			result = PromotionResultModel.create(appliedDiscount, null);
		}
		return result;
	}

}
