package com.backoffice.dao.models.delivery;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CourierDeliveryModel extends DeliveryTypeModel {

	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	@Temporal(TemporalType.TIME)
	private Date timePeriod;

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(final Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(final Date timePeriod) {
		this.timePeriod = timePeriod;
	}

}
