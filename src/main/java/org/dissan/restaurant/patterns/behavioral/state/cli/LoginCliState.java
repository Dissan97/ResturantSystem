package org.dissan.restaurant.patterns.behavioral.state.cli;

import org.dissan.restaurant.beans.BadCommanEntryException;
import org.dissan.restaurant.beans.EnumCommand;
import org.dissan.restaurant.beans.UserBean;
import org.dissan.restaurant.cli.utils.OutStream;
import org.dissan.restaurant.controllers.LoginController;
import org.dissan.restaurant.controllers.exceptions.UserAlreadyExistException;
import org.dissan.restaurant.controllers.exceptions.UserCredentialException;
import org.dissan.restaurant.patterns.behavioral.state.cli.exceptions.CliUiException;
import org.dissan.restaurant.patterns.creational.factory.StateFactory;
import java.io.IOException;
import java.text.ParseException;

public class LoginCliState extends CliState{

    private final LoginController controller;
    private final UserBean bean;
    private static final String CONTINUE = "continue? y to continue";
    public LoginCliState() {
        super(LoginCliState.class.getSimpleName());
        super.pageName = "LOGIN";
        controller = new LoginController();
        this.bean = controller.getUserBean();
    }

    @Override
    public void updateUi() {
            String cmd = super.getUserInput();

            if (super.parseCmd(cmd)) {
                this.updateUi();
                return;
            }

            try {
                switch (cmd) {
                    case "sign_up":
                    case "1":
                        signUp(0);
                        updateUi();
                        break;
                    case "sign_in":
                    case "2":
                        signIn(0);
                        CliState state = StateFactory.getInstance(CliStateEnum.valueOf(this.bean.getRole().name()), bean);
                        this.changeState(state);
                        break;
                    case "help":
                    case "3":
                        help();
                        updateUi();
                        break;
                    case "exit":
                    case "4":
                        break;
                    default:
                        super.logger.warning("Something wrong");
                        updateUi();
                        break;
                }

            } catch (UserAlreadyExistException | ParseException | BadCommanEntryException | IOException | UserCredentialException e) {
                outline(e.getMessage());
                updateUi();
            } catch (CliUiException e) {
                CliState state;
                try {
                    state = StateFactory.getInstance(CliStateEnum.HOME);
                } catch (CliUiException ex) {
                    outline("Something wrong");
                    return;
                }
                state.updateUi();
            }

    }

    private void signUp(int op) throws CliUiException, UserAlreadyExistException, BadCommanEntryException, ParseException, IOException {
        try {
            while (op < 7) {
                switch (op) {
                    case 0:
                        insertOp(EnumCommand.USERNAME, EnumCommand.USERNAME.name().toLowerCase());
                        op = 1;
                        break;
                    case 1:
                        insertOp(EnumCommand.PASSWORD, EnumCommand.PASSWORD.name().toLowerCase());
                        op = 2;
                        break;
                    case 2:
                        insertOp(EnumCommand.NAME, EnumCommand.NAME.name().toLowerCase());
                        op = 3;
                        break;
                    case 3:
                        insertOp(EnumCommand.SURNAME, EnumCommand.SURNAME.name().toLowerCase());
                        op = 4;
                        break;
                    case 4:
                        insertOp(EnumCommand.CITY_OF_BIRH, EnumCommand.CITY_OF_BIRH.name().toLowerCase());
                        op = 5;
                        break;
                    case 5:
                        insertOp(EnumCommand.DATE_OF_BIRTH, EnumCommand.DATE_OF_BIRTH.name().toLowerCase());
                        op = 6;
                        break;
                    case 6:
                        insertOp(EnumCommand.ROLE, EnumCommand.ROLE.name().toLowerCase());
                        op = 7;
                        break;
                    default:
                        break;
                }
            }

        }catch (BadCommanEntryException e) {
            super.outline(e.getMessage());
            String cmd = super.getUserInput(LoginCliState.CONTINUE);
            if (cmd.equalsIgnoreCase("y") || cmd.equalsIgnoreCase("yes")) {
                this.signUp(op);
            }else {
                this.bean.clean();
                throw new CliUiException("No command restart...");
            }
        }

        this.controller.singUp();
    }

    private void signIn(int op) throws UserCredentialException, CliUiException, BadCommanEntryException {

        try {
            while (op < 2) {
                switch (op) {
                    case 0:
                        insertOp(EnumCommand.USERNAME, EnumCommand.USERNAME.name().toLowerCase());
                        op = 1;
                        break;
                    case 1:
                        op = 2;
                        insertOp(EnumCommand.PASSWORD, EnumCommand.PASSWORD.name().toLowerCase());
                        break;
                    default:
                        op = 3;
                        break;
                }
            }
        }catch (BadCommanEntryException e) {
            super.outline(e.getMessage());
            String cmd = super.getUserInput(LoginCliState.CONTINUE);
            if (cmd.equalsIgnoreCase("y") || cmd.equalsIgnoreCase("yes")) {
                this.signIn(op);
            }else {
                this.bean.clean();
                throw new CliUiException("No command restart...");
            }
        }
        this.controller.singIn();
    }

    private void insertOp(EnumCommand command, String cmd) throws BadCommanEntryException {
        String msg = super.getUserInput(cmd);
        this.bean.insertCommand(command, msg);
    }

    public static void main(String[] args) {
        LoginCliState state = new LoginCliState();
        state.updateUi();
    }

}
