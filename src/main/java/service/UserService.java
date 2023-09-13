package service;

import dao.UserDao;
import dto.UserDto;
import entity.User;
import mapper.Mapper;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private static UserDao userDao = UserDao.getInstance();
    private static Mapper mapper = Mapper.getInstance();

    public User create(UserDto userDto){
        User mappedUser = mapper.mapFrom(userDto);
        return userDao.save(mappedUser);
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
