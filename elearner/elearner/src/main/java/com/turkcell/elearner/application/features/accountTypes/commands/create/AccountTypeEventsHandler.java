package com.turkcell.elearner.application.features.accountTypes.commands.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.turkcell.elearner.domain.AccountType;
import com.turkcell.elearner.persistence.AccountTypeRepository;

@Component
public class AccountTypeEventsHandler {

	private AccountTypeRepository accountTypeRepository;

	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}

	@EventHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		//checkIf vs.. kontrolleri burda
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		accountTypeRepository.save(accountType);
	}

}
