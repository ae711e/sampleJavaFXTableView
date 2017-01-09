package sample;

import java.sql.*;

/**
 * Created by ae on 09.01.2017.
 */
public class Sqlite {
  private Connection db;
  private Statement  st;
  
  // создаем подключение к БД
  public Sqlite(String nameDb)
  {
    db=null;
    st=null;
    try {
      Class.forName("org.sqlite.JDBC");
      db = DriverManager.getConnection("jdbc:sqlite:" + nameDb);
      st=db.createStatement();
    } catch (Exception e) {
      this.Close();
      e.printStackTrace();
    }
  }
  
  // выполняет запрос к БД
  public ResultSet ExecSql(String sql)
  {
    ResultSet rst=null;
    if(st!=null) {
      try {
        rst=st.executeQuery(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return rst;
  }
  
  public void Close()
  {
    try {
      if(st!=null) {
        st.close();
      }
      if(db!=null) {
          db.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
    
  
}
