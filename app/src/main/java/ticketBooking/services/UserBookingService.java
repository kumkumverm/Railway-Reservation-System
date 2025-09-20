package ticketBooking.services;

import ticketBooking.entities.User;
import ticketBooking.util.UserServiceUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class UserBookingService {
    private User user;
    private List<User> userList;
    private  ObjectMapper objectMapper= new ObjectMapper();
    private static final String USERS_PATH="app/src/main/resources/localDb/users.json";
    public UserBookingService(User user1) throws IOException{
        this.user=user1;
        loadUsers();
    }
    public UserBookingService()throws IOException{
        loadUsers();
    }
    // public List<User> loadUsers() throws IOException{
    //     File users=new File(USERS_PATH);
    //     return objectMapper.readValue(users, new TypeReference<List<User>>() {});
    // }
    //load from class path instead of file system
    public List<User> loadUsers() throws IOException {
    InputStream is = getClass().getClassLoader().getResourceAsStream("localDb/users.json");
    if (is == null) {
        throw new FileNotFoundException("users.json not found in resources");
    }
    return objectMapper.readValue(is, new TypeReference<List<User>>() {});
}
    public Boolean loginUser(){
        Optional<User> foundUser= userList.stream().filter(user1->{
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch(IOException ex){
           
         } return Boolean.FALSE;
        }
        private void saveUserListToFile() throws IOException{
            File usersFile=new File(USERS_PATH);
            objectMapper.writeValue(usersFile, userList);
        }
        public void fetchBooking(){
            System.out.println("Fetching your bookings");
            user.printTickets();
        }
        public Boolean CancelBooking(String ticketId){
            return Boolean.TRUE;
        }
}
