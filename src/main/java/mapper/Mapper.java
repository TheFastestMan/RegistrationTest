package mapper;

import dto.UserDto;
import entity.Gender;
import entity.Role;
import entity.User;

public class Mapper {
    private static final Mapper INSTANCE = new Mapper();

    public User mapFrom(UserDto object) {
        return User.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .build();

    }

    public static Mapper getInstance() {
        return INSTANCE;
    }
}
