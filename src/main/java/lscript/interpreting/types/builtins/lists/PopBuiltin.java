package lscript.interpreting.types.builtins.lists;

import lscript.Tuple;
import lscript.interpreting.Context;
import lscript.interpreting.RTResult;
import lscript.interpreting.types.BuiltInFunction;
import lscript.interpreting.types.LInt;
import lscript.interpreting.types.LList;
import lscript.interpreting.types.builtins.IExecutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PopBuiltin implements IExecutable {
    @Override
    public List<List<Tuple<String, String>>> getArgNames() {
        return Collections.singletonList(Arrays.asList(Tuple.of("list", "container"), Tuple.of("int", "index")));
    }

    @Override
    public String getName() {
        return "pop";
    }

    @Override
    public RTResult execute(Context execCtx, int execNum, BuiltInFunction fun) {
        LList list = (LList) execCtx.getSymbolTable().get("container");
        return new RTResult().success(list.getElements().remove(((LInt) execCtx.getSymbolTable().get("index")).getValue().intValue()).setPos(fun.getPosStart(), fun.getPosEnd()).setContext(fun.getContext()));
    }
}
