package org.dissan.restaurant.models;

import org.dissan.restaurant.exceptions.BadRoleException;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;

public class ConcreteUser extends LoggedUser {

    private Role role;
    public ConcreteUser(String usr, String pwd) {
        super(usr, pwd);
    }

    public ConcreteUser(String usr, String password, String name, String surname, String date, String role) throws ParseException, BadRoleException {
        super(usr, password, name, surname, date);
        doRoleSpecificAction(role);

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void doRoleSpecificAction(@NotNull String role) throws BadRoleException {
        switch (role.toUpperCase()){
            case "MANAGER":
                this.role = new Manager();
                break;
            case "COOKER":
                this.role = new Cooker();
                break;
            case "WAITER":
                this.role = new Waiter();
                break;
            case "NORMAL_USER":
                this.role = new NormalUser();
               break;
            default:
                throw new BadRoleException("NO USER FOUND");
        }
    }




}