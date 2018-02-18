package by.itacademy;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pagination")
public class Pagination extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nextPage = 1;
        if (!(req.getParameter("nextPage") == null || req.getParameter("nextPage").isEmpty())) {
            nextPage = Integer.parseInt(req.getParameter("nextPage"));
        }

        int numberOfRows = 1;
        if (!(req.getParameter("numberOfRows") == null || req.getParameter("numberOfRows").isEmpty())) {
            numberOfRows = Integer.parseInt(req.getParameter("numberOfRows"));
        }

        String name = "";
        GameService gameService = new GameService();
        if (!(req.getParameter("name") == null)) {
            name = req.getParameter("name");
        }
        int cost = 0;
        if (!(req.getParameter("cost") == null || req.getParameter("cost").isEmpty())) {
            cost = Integer.parseInt(req.getParameter("cost"));
        }
        int ageRestrictions = 0;
        if (!(req.getParameter("ageRestrictions") == null || req.getParameter("ageRestrictions").isEmpty())) {
            ageRestrictions = Integer.parseInt(req.getParameter("ageRestrictions"));
        }

        Language language = null;
        if (!(req.getParameter("language") == null || req.getParameter("language").isEmpty())) {
            language = Language.valueOf(req.getParameter("language"));
        }


        List<Game> games = gameService.nextPageWithFilter(nextPage, numberOfRows, name, cost, ageRestrictions, language).getContent();


        req.setAttribute("name", name);
        req.setAttribute("language", language);
        req.setAttribute("age", ageRestrictions);
        req.setAttribute("cost", cost);
        req.setAttribute("currentNumberOfRows", numberOfRows);
        req.setAttribute("currentPage", nextPage);
        req.setAttribute("allGames", games);


        req.getRequestDispatcher("WEB-INF/jsp/firstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
