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
public class PromotionDTO implements Serializable{
    private int promotionID;
    private String promotionName;

    public PromotionDTO() {
    }

    public PromotionDTO(int promotionID, String promotionName) {
        this.promotionID = promotionID;
        this.promotionName = promotionName;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }
    
    
}
