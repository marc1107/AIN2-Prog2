package aufgabe8;

import java.util.Map;

public class Product extends CompoundExpression {
    public Product (Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    @Override
    public double eval(Map<String, Double> expr) {
        return this.expr1.eval(expr) * this.expr2.eval(expr);
    }

    @Override
    public String toString() {
        return "(" + this.expr1.toString() + " * " + this.expr2.toString() + ")";
    }
}
