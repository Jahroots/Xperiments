package fr.jahroots.xperiments.jee.dao;

import javax.enterprise.inject.Default;

/**
 * @author Jahroots.
 */
@Default
public class UserDao {
    public String save() {
        return "SaveUser";
    }
}
