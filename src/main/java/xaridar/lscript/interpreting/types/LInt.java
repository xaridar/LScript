package xaridar.lscript.interpreting.types;

/*
 * LScript is an interpreted scripting language with static typing, written in Java by Xaridar.
 *
 * @version 2.0.0
 * @author Xaridar
 */

/**/
public class LInt extends LNumber {

    private final int value;

    public LInt(int value) {
        super("int", Integer.valueOf(value));
        this.value = value;
    }

    @Override
    public LInt copy() {
        LInt b = new LInt(value);
        b.setContext(getContext());
        b.setPos(getPosStart(), getPosEnd());
        return b;
    }

    @Override
    public Integer getValue() {
        return Integer.valueOf(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
