package com.backoffice.service.strategy.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.backoffice.service.strategy.EntryModeificationStrategy;
import com.backoffice.service.strategy.EntryModificationType;

@Component
public class EntryModificationStrategyFactory {

	private Map<EntryModificationType, EntryModeificationStrategy> startegyMapping;

	public EntryModeificationStrategy getStrategy(final EntryModificationType type) {

		return startegyMapping.get(type);
	}

	public Map<EntryModificationType, EntryModeificationStrategy> getStartegyMapping() {
		return startegyMapping;
	}

	public void setStartegyMapping(final Map<EntryModificationType, EntryModeificationStrategy> startegyMapping) {
		this.startegyMapping = startegyMapping;
	}

}
