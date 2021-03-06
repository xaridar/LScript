package xaridar.lscript.interpreting.types.builtins.lists;

/*
 * LScript is an interpreted scripting language with static typing, written in Java by Xaridar.
 *
 * @version 2.0.0
 * @author Xaridar
 */

import xaridar.lscript.Tuple;
import xaridar.lscript.interpreting.Context;
import xaridar.lscript.interpreting.RunTimeResult;
import xaridar.lscript.interpreting.types.*;
import xaridar.lscript.interpreting.types.builtins.IExecutable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RemoveBuiltin implements IExecutable {
    @Override
    public List<List<Tuple<String, String>>> getArgNames() {
        return Arrays.asList(Arrays.asList(Tuple.of("list", "container"), Tuple.of("var", "value")), Arrays.asList(Tuple.of("map", "container"), Tuple.of("var", "value")));
    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public RunTimeResult execute(Context execCtx, int execNum, BuiltInFunction fun) {
        Value ret;
        if (execNum == 0) {
            LList list = (LList) execCtx.getSymbolTable().get("container");
            Optional<Value> v = list.getElements().stream().filter(val -> val.equalTo(execCtx.getSymbolTable().get("value")).isTrue()).findFirst();
            ret = new LBoolean(v.isPresent());
            v.ifPresent(value -> list.getElements().remove(value));
        } else if (execNum == 1) {
            LMap map = (LMap) execCtx.getSymbolTable().get("container");
            Optional<Value> v = map.getMap().keySet().stream().filter(val -> val.equalTo(execCtx.getSymbolTable().get("value")).isTrue()).findFirst();
            ret = v.isPresent() ? map.getMap().get(v.get()) : NullType.Null;
            v.ifPresent(val -> {
                map.getMap().remove(val);
            });
        } else {
            return null;
        }
        return new RunTimeResult().success(ret.setPos(fun.getPosStart(), fun.getPosEnd()).setContext(fun.getContext()));
    }
}
