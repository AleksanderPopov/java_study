package org.stepic.java.chapter3;

/**
 * Created by apop on 7/7/2016.
 */
public class ComplexNumber {
    private final double re;
    private final double im;
    int hash = 0;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComplexNumber)) return false;
        if (obj == this) return true;
        if (((ComplexNumber) obj).getIm() == this.getIm() & ((ComplexNumber) obj).getRe() == this.getRe()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        if (hash == 0 & (im != 0 || re != 0)) {
            hash = (int) ((im * 13 + re * 13) * 13);
            return hash;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Im is - " + Double.toString(im) + ", Re is - " + Double.toString(re);
    }
}
