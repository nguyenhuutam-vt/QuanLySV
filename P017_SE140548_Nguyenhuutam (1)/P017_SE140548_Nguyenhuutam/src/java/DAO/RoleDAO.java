/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RoleDTO;
import DTO.UserDTO;
import Ulities.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class RoleDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<RoleDTO> getListRole() throws NamingException, SQLException, ClassNotFoundException {
        List<RoleDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select RoleID,RoleName\n"
                        + "from tblRoles";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int roleID = rs.getInt("RoleID");
                    String roleName = rs.getString("RoleName");
                    
                    list.add(new RoleDTO(roleID, roleName));
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
