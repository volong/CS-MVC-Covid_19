package Controller.user;

import Model.News;
import Service.NewsJDBCServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsServlet", urlPatterns = "/home")
public class NewsServlet extends HttpServlet {
    private NewsJDBCServiceImpl newsJDBCService = new NewsJDBCServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "news":
                viewNews(request, response);
                break;
            default:
                home(request, response);
                break;
        }
    }


    private void viewNews(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        News news = this.newsJDBCService.findById(id);
        RequestDispatcher dispatcher;
        if (news == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("news", news);
            dispatcher = request.getRequestDispatcher("/WEB-INF/news.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        List<News> news = this.newsJDBCService.findAll();
        request.setAttribute("news", news);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

