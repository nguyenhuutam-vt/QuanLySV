/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProDetailDTO implements Serializable{
    private int proDetailID;
    private int proID;
    private UserDTO user;
    private String dateJoin;
    

    public ProDetailDTO() {
    }

    public ProDetailDTO(int proDetailID, int proID, UserDTO user, String dateJoin) {
        this.proDetailID = proDetailID;
        this.proID = proID;
        this.user = user;
        this.dateJoin = dateJoin;
        
    }

    public int getProDetailID() {
        return proDetailID;
    }

    public void setProDetailID(int proDetailID) {
        this.proDetailID = proDetailID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    
}
