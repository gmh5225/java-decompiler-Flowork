package io.github.r1mao.ir;

import io.github.r1mao.algorithm.Node;
import javafx.util.Pair;

import java.util.HashMap;


public class IRBasicBlock extends Node<CodeBlock>
{
    private HashMap<Integer, Pair<String,String>> localVariable=new HashMap<>();
    private int stackOffset=0xdeadbeef;
    private int stackAddress=0xdeadbeef;
    public IRBasicBlock(CodeBlock data, IRMethod parent)
    {
        super(data, parent);
        data.setHolder(this);
    }
    public String getName()
    {
        String name="block";
        if(this.isTryCatchHandler())
            name="handler";
        return name+"_"+this.getParent().getNodes().indexOf(this);
    }
    public CodeBlock getCode()
    {
        return this.getData();
    }
    public void setStackOffset(int offset)
    {
        if(this.stackOffset==0xdeadbeef)
            this.stackOffset=offset;
        else if(this.stackOffset!=offset)
            assert false;
    }
    public int getStackOffset()
    {
        return this.stackOffset;
    }
    public void setStackAddress(int offset)
    {
        if(this.stackAddress==0xdeadbeef)
            this.stackAddress=offset;
        else if(this.stackAddress!=offset)
            assert false;
    }
    public boolean isTryCatchHandler()
    {
        return ((IRMethod)this.getParent()).getTryCatchHandlerBlocks().contains(this);
    }

    public int getStackAddress()
    {
        return this.stackAddress;
    }
}
