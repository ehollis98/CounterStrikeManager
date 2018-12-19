package counterStrikeManager.controller;

import counterStrikeManager.entity.User;
import counterStrikeManager.entity.Role;
import counterStrikeManager.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/newUser"}
)

public class NewUserServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        GenericDAO userDao = new GenericDAO(User.class);
        User newUser = new User();

        // Set the response message's MIME type
        response.setContentType("text/html; charset=UTF-8");

        //Get values from form and insert into user
        String firstName = request.getParameter("firstName");
        newUser.setFirstName(firstName);

        String lastName = request.getParameter("lastName");
        newUser.setLastName(lastName);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        newUser.setUsername(username);
        newUser.setPassword(password);

        Role role = new Role();
        role.setUser(newUser);
        role.setUserName(username);
        role.setRoleName("user");
        newUser.addRole(role);

        userDao.insert(newUser);

        //Set Attributes to forward to jsp
        request.setAttribute("firstname", firstName);
        request.setAttribute("lastname", lastName);
        request.setAttribute("username", username);
        request.setAttribute("password", password);


        //Forward result to jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUserResult.jsp");
        dispatcher.forward(request, response);

    }

}