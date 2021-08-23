/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RoleDAO;
import DAO.UserDAO;
import DTO.HistoryDTO;
import DTO.ProDetailDTO;
import DTO.PromotionDTO;
import DTO.RoleDTO;
import DTO.UserDTO;
import Ulities.Encrypt_Password;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.jsp";
        String userName = request.getParameter("txtUserName");
        String pw = request.getParameter("txtPassword");
        
        
        try{
            
            HttpSession session = request.getSession();
            
            UserDAO dao = new UserDAO();
            RoleDAO roleDAO = new RoleDAO();
            
            String converPass = Encrypt_Password.encrypt(pw);
            
            UserDTO dto = dao.getAccount(userName, converPass);
            
            List<PromotionDTO> listPro = dao.getListPromotion();
            List<UserDTO> list = dao.getListAccount();
            List<RoleDTO> listRole = roleDAO.getListRole();
            
            
            if(dto!=null){
                List<HistoryDTO> listHistory = dao.getListHistory(dto.getUserID());
                if(1 == dto.getRoleID()){
                    url = "home.jsp";
                }else{
                    url = "managerUsers.jsp";
                }               
                session.setAttribute("ListAccount", list);
                session.setAttribute("ListRole", listRole);
                session.setAttribute("ListPromotion", listPro);          
                session.setAttribute("ListHistory", listHistory);          
                session.setAttribute("ManageUser", dto);
                session.setAttribute("roleID", dto.getRoleID());
            }else{
                request.setAttribute("LoginFailed", "Not Found");
            }
           
        } catch (SQLException ex) {
            log("LoginController + SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginController + ClassNotFoundException: " + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            log("LoginController + NoSuchAlgothmException: " + ex.getMessage());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
