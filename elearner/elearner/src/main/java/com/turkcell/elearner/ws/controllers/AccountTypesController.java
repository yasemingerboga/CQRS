package com.turkcell.elearner.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.elearner.application.features.accountTypes.commands.create.CreateAccountTypeCommand;
import com.turkcell.elearner.ws.models.CreateAccountTypeModel;

@RestController
@RequestMapping("/accounttypes")
public class AccountTypesController {
	private CommandGateway commandGateway;

	public AccountTypesController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping()
	public void CreateAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel) {

		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder().price(createAccountTypeModel.getPrice())
				.accountName(createAccountTypeModel.getAccountName())
				.description(createAccountTypeModel.getDescription()).build();

		command.setAccountTypeId(UUID.randomUUID().toString());

		commandGateway.sendAndWait(command);
	}

}
