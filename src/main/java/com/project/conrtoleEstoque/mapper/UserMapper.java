package com.project.conrtoleEstoque.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.project.conrtoleEstoque.dto.UserDto;
import com.project.conrtoleEstoque.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(source = "birthDate", target =  "birthDate", dateFormat = "dd/MM/yyyy")
	User toModel(UserDto obj);
	
	UserDto toDto(User obj);
}
