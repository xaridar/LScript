package xaridar.lscript.interpreting.types.builtins;

import xaridar.lscript.Tuple;
import xaridar.lscript.interpreting.Context;
import xaridar.lscript.interpreting.RunTimeResult;
import xaridar.lscript.interpreting.types.BuiltInFunction;
import xaridar.lscript.interpreting.types.LString;

import java.util.Collections;
import java.util.List;

public class StrBuiltin implements IExecutable {
    @Override
    public List<List<Tuple<String, String>>> getArgNames() {
        return Collections.singletonList(Collections.singletonList(Tuple.of("var", "val")));
    }

    @Override
    public String getName() {
        return "tostring";
    }

    @Override
    public RunTimeResult execute(Context execCtx, int execNum, BuiltInFunction fun) {
        return new RunTimeResult().success(new LString(execCtx.getSymbolTable().get("val").toString()).setPos(fun.getPosStart(), fun.getPosEnd()).setContext(fun.getContext()));
    }
}
