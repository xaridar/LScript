package xaridar.lscript.parsing.nodes;

/*
 * LScript is an interpreted scripting language with static typing, written in Java by Xaridar.
 *
 * @version 2.0.0
 * @author Xaridar
 */

import xaridar.lscript.lexing.Position;

/**
 * A simple Node representing a 'continue' statement.
 */
public class ContinueNode extends Node {
    /**
     * @param posStart - the start Position of this Node.
     * @param posEnd - the end position of this Node.
     */
    public ContinueNode(Position posStart, Position posEnd) {
        super(posStart, posEnd);
    }
}
