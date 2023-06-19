package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "image", expression = "java(getUrlToAvatar())")
    UserDto userToUserDto(User user);

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateUser(UserDto userDto, @MappingTarget User user);

    default String getUrlToAvatar() {
        return "/users/me/image";
    }
}
