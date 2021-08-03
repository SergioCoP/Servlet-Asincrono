package mx.edu.utez.model.Game;

import mx.edu.utez.model.Category.BeanCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.edu.utez.service.ConnectionMySQL;

public class DaoGame {
private Connection con;
private CallableStatement cstm;
private ResultSet rs;
final private Logger CONSOLE = LoggerFactory.getLogger(DaoGame.class);

//procedimientos para crear, modificar, eliminar, buscartodos y encontrar por id

    public List<BeanGame> findAll(){
        List<BeanGame> listGames = new ArrayList<>();
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call findall}");
            rs = cstm.executeQuery();

            while(rs.next()){
             BeanGame beanGame = new BeanGame();
                BeanCategory beanCategory = new BeanCategory();

                beanGame.setIdGame(rs.getInt("idGame"));
                beanGame.setNameGame(rs.getString("nameGame"));
                beanGame.setDatePremiere(rs.getString("date_premiere"));
                beanGame.setStatus(rs.getInt("status"));
                beanGame.setCategory_idCategory(rs.getInt("idCategory"));


                listGames.add(beanGame);
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listGames;
    }


    public BeanGame findbyid(int id){
        BeanGame beanGame = null;
        try {
            // SELECT * FROM users AS U INNER JOIN persons AS P ON U.idPerson = P.id INNER JOIN roles AS R ON U.idRole = R.id;
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{select*from game as g inner join category as c on g.Category_idCategory = c.idCategory where g.idGame = ?}");
            cstm.setInt(1,id);
            rs = cstm.executeQuery();

            while(rs.next()){
                beanGame = new BeanGame();

                beanGame.setIdGame(rs.getInt("idGame"));
                beanGame.setNameGame(rs.getString("nameGame"));
                beanGame.setDatePremiere(rs.getString("date_premiere"));
                beanGame.setStatus(rs.getInt("status"));
                beanGame.setCategory_idCategory(rs.getInt("idCategory"));
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return beanGame;
    }


    public boolean create(BeanGame game){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call registerGame(?,?,?,?)}");
          cstm.setString(1,game.getNameGame());
          cstm.setString(2, game.getDatePremiere());
          cstm.setInt(3,game.getCategory_idCategory());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanGame game){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call modifyGame(?,?,?,?,?)}");
            cstm.setInt(1,game.getIdGame());
            cstm.setString(2,game.getNameGame());
            cstm.setString(3, game.getDatePremiere());
            cstm.setInt(4,game.getCategory_idCategory());

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int idGame){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call deleteTemporalGame(?)}");
            cstm.setInt(1, idGame);

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}
