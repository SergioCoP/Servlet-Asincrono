package mx.edu.utez.controller;

import com.google.gson.Gson;
import mx.edu.utez.model.Category.BeanCategory;
import mx.edu.utez.model.Game.BeanGame;
import mx.edu.utez.model.Game.DaoGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig /*Va poder obtener imagenes o documentos*/

@WebServlet(name = "ServletGame", urlPatterns = {"/readGames", "/createGame", "/updateGame", "/deleteGame"})
public class ServletGame extends HttpServlet {
    private Map map = new HashMap();
    final private Logger CONSOLE = LoggerFactory.getLogger(ServletGame.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
   if(session.getAttribute("session") != null){
       // request.setAttribute("listGames",new DaoGame().findAll());
        // request.getRequestDispatcher("views/game/games.jsp").forward(request,response);

        map.put("listGames", new DaoGame().findAll());
        write(response, map); //de esta forma se manda de forma asincrona

   }else{request.getRequestDispatcher("/").forward(request,response);
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-0");
    String action = request.getParameter("action");
        DaoGame daoGame = new DaoGame();
        BeanCategory beanCategory = new BeanCategory();
        BeanGame beanGame = new BeanGame();
    switch(action){
        case "create":
            Part part = request.getPart("txtimage");//obtener la imagen o documento
            InputStream image = part.getInputStream();//se convierte a input string

           beanCategory.setIdCategory(Integer.parseInt(request.getParameter("txtidCategory")));

           beanGame.setNameGame(request.getParameter("txtname"));
           beanGame.setDatePremiere(request.getParameter("txtdate"));
           beanGame.setCategory_idCategory(beanCategory);

            boolean flag = daoGame.create(beanGame,image);

            if(flag){
               map.put("message","Registrado");

            }else{
                map.put("message","No se registro");
            }
            write(response, map);//pasaamos el repsonso junto con el map
            break;
        case "update":
            /*Part part = request.getPart("image");//obtener la imagen o documento
            InputStream image = part.getInputStream();//se convierte a input string*/
            beanCategory.setIdCategory(Integer.parseInt(request.getParameter("idCategory")));

            beanGame.setIdGame(Integer.parseInt("idGame"));
            beanGame.setNameGame(request.getParameter("name"));
            beanGame.setDatePremiere(request.getParameter("date"));
            beanGame.setCategory_idCategory(beanCategory);

            boolean flag1 = daoGame.update(beanGame);

            if(flag1){
                CONSOLE.error("Actualizado");
            }else{
                CONSOLE.error("No se actualizó");
            }

            break;
        case "delete":
            if(new DaoGame().delete(Integer.parseInt(request.getParameter("idGame")))) {
                //true

            }else{
                //false
            }
            break;
        default:
            request.getRequestDispatcher("/").forward(request, response);
break;
    }
    response.sendRedirect(request.getContextPath() + "/readGames");
    }

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(map));
    }




}
