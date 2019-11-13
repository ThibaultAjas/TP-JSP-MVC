/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yay.jsp.mvc.resources;

import java.util.Objects;

/**
 *
 * @author Dalfrak
 */
public class RateEntity {

    private String code;
    private float rate;

    public RateEntity() {
        this.code = "";
        this.rate = 0f;
    }

    public RateEntity(String code, float rate) {
        this.code = code.charAt(0) + "";
        this.rate = rate;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RateEntity other = (RateEntity) obj;
        if (Float.floatToIntBits(this.rate) != Float.floatToIntBits(other.rate))
            return false;
        if (!Objects.equals(this.code, other.code))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RateEntity{" + "code=" + code + ", rate=" + rate + '}';
    }

}
