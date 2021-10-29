package data;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    Integer number;
    List<NestedInteger> list;

    public NestedIntegerImpl(Integer number, List<NestedInteger> list){
        this.number = number;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return number != null;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
