/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class HistoryDTO implements Serializable{
    private String userName;
    private String proName;
    private int rank;
    private String dateIn;

    public HistoryDTO() {
    }

    public HistoryDTO(String userName, String proName, int rank, String dateIn) {
        this.userName = userName;
        this.proName = proName;
        this.rank = rank;
        this.dateIn = dateIn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    
    
}
