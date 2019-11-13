/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yay.jsp.mvc.resources;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Dalfrak
 */
public class Rates extends ArrayList<RateEntity> {

    public Rates(int initialCapacity) {
        super(initialCapacity);
    }

    public Rates() {
        super();
    }

    public Rates(Collection c) {
        super(c);
    }

    public void deleteRate(RateEntity rate) {
        int tmp = -1;
        
        for (int i = 0; i < this.size(); i++) {
            RateEntity r = this.get(i);
            if (r.equals(rate)) {
                tmp = i;
                break;
            }
        }
        if (tmp > -1)
            this.remove(tmp);
    }

    public void updateRate(RateEntity oldRate, Float newRate) {
        for (RateEntity r : this)
            if (r.getCode().equals(oldRate.getCode())) {
                r.setRate(newRate);
                break;
            }
    }
    
    public RateEntity getRateFromCode(String code) {
        for (RateEntity r : this)
            if (r.getCode().equals(code))
                return r;
        return null;
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
        final Rates other = (Rates) obj;
        if (this.size() != other.size())
            return false;
        for (int i = 0; i < this.size(); i++)
            if (!this.get(i).equals(other.get(i)))
                return false;
        return true;
    }

}
