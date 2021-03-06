package xaridar.lscript.parsing.nodes;

/*
 * LScript is an interpreted scripting language with static typing, written in Java by Xaridar.
 *
 * @version 2.0.0
 * @author Xaridar
 */

import xaridar.lscript.lexing.Token;

/**
 * A simple Node representing a string of characters.
 */
public class StringNode extends Node {
    private final Token token;

    /**
     * @param token - A Token representing the String value of the Node.
     */
    public StringNode(Token token) {
        super(token.getPosStart(), token.getPosEnd());
        this.token = token;
    }

    /**
     * @return a String representation of the Node for debugging.
     */
    @Override
    public String toString() {
        return token.toString();
    }

    /**
     * @return a Token representing the String of the node.
     */
    public Token getToken() {
        return token;
    }
}
