package Controller.admin;

import Model.News;
import Service.NewsJDBCService;
import Service.NewsJDBCServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNews(request, response);
                break;
            case "delete":
                deleteNews(request, response);
                break;
            case "update":
                updateNews(request, response);
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> news = this.newsJDBCService.findAll();
        request.setAttribute("news", news);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("WEB-INF/admin.jsp");
        }
    }


    private NewsJDBCService<News> newsJDBCService = new NewsJDBCServiceImpl();

    private void createNews(HttpServletRequest request, HttpServletResponse response) {
        String date = request.getParameter("date");
        String title = request.getParameter("title");
        String img = request.getParameter("img");
        String content = request.getParameter("content");
        int id = (int) (Math.random() * 10000);

        News news = new News(id, date, title, img, content);
        this.newsJDBCService.save(news);

        List<News> news1 = this.newsJDBCService.findAll();
        request.setAttribute("news", news);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin");
        request.setAttribute("message", "New customer was created");

        try {
            response.sendRedirect("/admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteNews(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        News news = (News) this.newsJDBCService.findById(id);
        RequestDispatcher dispatcher;
        if (news == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.newsJDBCService.remove(id);
            try {
                response.sendRedirect("/admin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateNews(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String date = request.getParameter("date");
        String title = request.getParameter("title");
        String img = request.getParameter("img");
        String content = request.getParameter("content");
        News news = (News) this.newsJDBCService.findById(id);
        RequestDispatcher dispatcher;
        if (news == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            news.setDate(date);
            news.setTitle(title);
            news.setImg(img);
            news.setContent(content);
            this.newsJDBCService.update(id, news);
            request.setAttribute("news", news);
            request.setAttribute("message", "news was updated");
            List<News> news1 = this.newsJDBCService.findAll();
            request.setAttribute("news", news1);

            dispatcher = request.getRequestDispatcher("/admin");
        }
        try {
            response.sendRedirect("/admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
