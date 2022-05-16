package aufgabe8;

import java.util.Set;

public abstract class CompoundExpression implements Expression {
    protected Expression expr1;
    protected Expression expr2;

    public CompoundExpression (Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public Set<String> getVars() {
        Set<String> set = this.expr1.getVars();
        set.addAll(this.expr2.getVars());
        return set;
    }
}
