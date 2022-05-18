package aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression {
    private final double con;

    public Constant (double con) {
        this.con = con;
    }

    @Override
    public double eval(Map<String, Double> expr) {
        return this.con;
    }

    @Override
    public Set<String> getVars() {
        return new TreeSet<String>();
    }

    @Override
    public String toString() {
        return Double.toString(con);
    }
}
