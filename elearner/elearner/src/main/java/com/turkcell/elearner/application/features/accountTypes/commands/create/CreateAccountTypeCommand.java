package com.turkcell.elearner.application.features.accountTypes.commands.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountTypeCommand {
	@TargetAggregateIdentifier
	private String accountTypeId;
	private String accountName;
	private Double price;
	private String description;
}
