/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author User
 */
public class FileUserDAO implements UserDao{
    private FileWriter writer;
    private Scanner scanner;
    private List<User> list;
    
    public FileUserDAO(String fileName){
        list = new ArrayList<User>();
        try {
            scanner = new Scanner(new File("salasanat.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        try {
            writer = new FileWriter(fileName);
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }

    @Override
    public List<User> listAll() {
        while(scanner.hasNextLine()){
            String userLine = scanner.nextLine();
            String passLine = scanner.nextLine();
            list.add(new User(userLine, passLine));
        }
        return list;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        
        for (User user : users) {
            if(user.getUsername().equals(name)){
                return user;
            }
        }
        
        return null;
    }

    @Override
    public void add(User user) {
        try {
            writer.append(user.getUsername() + "\n" + user.getPassword() + "\n");
        } catch (IOException ex) {
            System.out.println("Error: Adding user failed");
        }
    }
    
}
