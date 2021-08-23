/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HistoryDTO;
import DTO.ProDetailDTO;
import DTO.PromotionDTO;
import DTO.UserDTO;
import Ulities.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UserDTO getAccount(String userName, String password) throws SQLException, NamingException, ClassNotFoundException {
        UserDTO user = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID\n"
                        + "from tblUsers\n"
                        + "where UserName = ? and PassWord = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);

                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String pw = rs.getString("PassWord");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String photo = rs.getString("Photo");
                    boolean status = rs.getBoolean("Status");
                    int rank = rs.getInt("intRank");
                    int roleID = rs.getInt("roleID");
                    int ProID = rs.getInt("ProID");

                    user = new UserDTO(id, name, pw, email, phone, photo, status, rank, roleID, ProID);

                    return user;
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    public UserDTO getUserByID(int userID) throws SQLException, NamingException, ClassNotFoundException {
        UserDTO user = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID\n"
                        + "from tblUsers\n"
                        + "where UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, userID);

                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String pw = rs.getString("PassWord");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String photo = rs.getString("Photo");
                    boolean status = rs.getBoolean("Status");
                    int rank = rs.getInt("intRank");
                    int roleID = rs.getInt("roleID");
                    int ProID = rs.getInt("ProID");

                    user = new UserDTO(id, name, pw, email, phone, photo, status, rank, roleID, ProID);

                    return user;
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListAccount() throws NamingException, SQLException, ClassNotFoundException {
        List<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID\n"
                        + "from tblUsers\n";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String pw = rs.getString("PassWord");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String photo = rs.getString("Photo");
                    boolean status = rs.getBoolean("Status");
                    int rank = rs.getInt("intRank");
                    int roleID = rs.getInt("roleID");
                    int ProID = rs.getInt("ProID");

                    list.add(new UserDTO(id, name, pw, email, phone, photo, status, rank, roleID, ProID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<UserDTO> getListByTag(int tag) throws NamingException, SQLException, ClassNotFoundException {
        List<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID\n"
                        + "from tblUsers\n"
                        + "where RoleID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, tag);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String pw = rs.getString("PassWord");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String photo = rs.getString("Photo");
                    boolean status = rs.getBoolean("Status");
                    int rank = rs.getInt("intRank");
                    int roleID = rs.getInt("roleID");
                    int ProID = rs.getInt("ProID");

                    list.add(new UserDTO(id, name, photo, email, phone, photo, status, rank, roleID, ProID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public int updateUser(int userID, String userName, String password, String email, String phone, String photo, boolean status, int rank, int roleID) throws NamingException, SQLException, ClassNotFoundException {

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update tblUsers\n"
                        + "set UserName = ?,PassWord = ?,Email = ?, Phone = ?, Photo = ?,Status = ?, intRank = ?, RoleID = ?\n"
                        + "where UserID = ?";

                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, photo);
                pst.setBoolean(6, status);
                pst.setInt(7, rank);
                pst.setInt(8, roleID);

                pst.setInt(9, userID);

                int rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return 0;
    }

    public int removeUser(int userID, boolean status) throws NamingException, SQLException, ClassNotFoundException {

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update tblUsers\n"
                        + "set Status = ?\n"
                        + "where UserID = ?";

                pst = con.prepareStatement(sql);
                pst.setBoolean(1, status);
                pst.setInt(2, userID);

                int rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return 0;
    }

    public List<UserDTO> getListAccountByName(String searchValue) throws NamingException, SQLException, ClassNotFoundException {
        List<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID\n"
                        + "from tblUsers\n"
                        + "where UserName like ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + searchValue + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("UserID");
                    String name = rs.getString("UserName");
                    String pw = rs.getString("PassWord");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String photo = rs.getString("Photo");
                    boolean status = rs.getBoolean("Status");
                    int rank = rs.getInt("intRank");
                    int roleID = rs.getInt("roleID");
                    int ProID = rs.getInt("ProID");

                    list.add(new UserDTO(id, name, pw, email, phone, photo, status, rank, roleID, ProID));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public int createUser(String userName, String password, String email, String phone, String photo, int rank, int roleID) throws NamingException, SQLException, ClassNotFoundException {

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert tblUsers(UserName,PassWord,Email,Phone,Photo,Status,intRank,roleID,ProID)\n"
                        + "values (?,?,?,?,?,?,?,?,?)";

                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, photo);
                pst.setBoolean(6, true);
                pst.setInt(7, rank);
                pst.setInt(8, roleID);
                pst.setNull(9, Types.NULL);

                int rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return 0;
    }

    ///////////////////// getList Promotion
    public List<PromotionDTO> getListPromotion() throws NamingException, SQLException, ClassNotFoundException {
        List<PromotionDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select ProID,ProName\n"
                        + "from tblPromotions";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProID");
                    String name = rs.getString("ProName");

                    list.add(new PromotionDTO(id, name));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    /////////////////////// Get list DetailPromotion
    public List<ProDetailDTO> getListDetailPromotion(int promotionID) throws NamingException, SQLException, ClassNotFoundException {
        List<ProDetailDTO> list = new ArrayList<>();
        UserDAO dao = new UserDAO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select detailID,dateJoin,UserID,ProID\n"
                        + "from tblDetailPromotion\n"
                        + "where ProID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, promotionID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("detailID");
                    String dateJoin = rs.getString("dateJoin");
                    int userID = rs.getInt("UserID");
                    int proID = rs.getInt("ProID");
                    UserDTO user = dao.getUserByID(userID);

                    list.add(new ProDetailDTO(id, proID, user, dateJoin));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public int insertDetailPromotion(int proID, int userID) throws NamingException, SQLException, ClassNotFoundException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert tblDetailPromotion(dateJoin,UserID,ProID)\n"
                        + "values (?,?,?)";

                pst = con.prepareStatement(sql);
                pst.setDate(1, sqlDate);
                pst.setInt(2, userID);
                pst.setInt(3, proID);

                int rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return 0;
    }

    public int removeDetailPromotion(int proID, int userID) throws NamingException, SQLException, ClassNotFoundException {

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "delete from tblDetailPromotion\n"
                        + "where UserID = ? and ProID = ?";

                pst = con.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setInt(2, proID);

                int rs = pst.executeUpdate();
                if (rs > 0) {
                    return rs;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return 0;
    }

    public int getFields(List<ProDetailDTO> listPro, int userID) {

        for (ProDetailDTO pro : listPro) {
            if (pro.getUser().getUserID() != userID) {
                return userID;
            }
        }

        return 0;
    }

    public List<HistoryDTO> getListHistory(int userID) throws SQLException, NamingException, ClassNotFoundException {
        List<HistoryDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select u.UserName, p.ProName, u.intRank, d.dateJoin\n"
                        + "from tblPromotions p ,tblUsers u, tblDetailPromotion d\n"
                        + "where u.UserID = d.UserID and p.ProID = d.ProID and u.UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, userID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String userName = rs.getString("UserName");
                    String proName = rs.getString("ProName");
                    int rank = rs.getInt("intRank");
                    String dateIn = rs.getString("dateJoin");
                    
                    list.add(new HistoryDTO(userName, proName, rank, dateIn));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

}
