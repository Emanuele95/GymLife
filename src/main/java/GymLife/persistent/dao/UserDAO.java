package GymLife.persistent.dao;

import GymLife.persistent.entity.User;

public interface UserDAO {

    public void addUser(User user);

    public User getUser(String email);

    public User getUserName(String nome);
    
    public User getId(int id);

}
