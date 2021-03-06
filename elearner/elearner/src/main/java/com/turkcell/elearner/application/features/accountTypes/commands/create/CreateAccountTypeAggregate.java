package com.turkcell.elearner.application.features.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateAccountTypeAggregate {
	@AggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private String description;

	public CreateAccountTypeAggregate() {

	}

	@CommandHandler
	public CreateAccountTypeAggregate(CreateAccountTypeCommand createAccountTypeCommand) {
		// global business codes : loglama vs.. 
		AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();

		BeanUtils.copyProperties(createAccountTypeCommand, accountTypeCreatedEvent);

		AggregateLifecycle.apply(accountTypeCreatedEvent);

	}

	@EventSourcingHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		// event sourcing code
		accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
		accountName = accountTypeCreatedEvent.getAccountName();
		description = accountTypeCreatedEvent.getDescription();

	}

}
