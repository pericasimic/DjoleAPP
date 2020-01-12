package djoleapp.controller.event;

import djoleapp.controller.event.adminevent.LoginEvent;

/**
 *
 * @author perica.simic
 */
public class ManagerEvent {

    private LoginEvent loginEvent = null;

    public ManagerEvent() {

        loginEvent = new LoginEvent();
    }

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }
    
    
}