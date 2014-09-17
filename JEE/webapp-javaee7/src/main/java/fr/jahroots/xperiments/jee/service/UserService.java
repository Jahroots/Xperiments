package fr.jahroots.xperiments.jee.service;

import fr.jahroots.xperiments.jee.dao.UserDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Jahroots.
 */
@Path("users")
public class UserService {

    @Inject
    private UserDao userDao;

    @GET
    @Produces("text/plain")
    public String index() {
        final String text = userDao.save();
        return text;
    }
}
