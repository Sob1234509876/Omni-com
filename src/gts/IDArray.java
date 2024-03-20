package src.gts;

import java.util.ArrayList;

import src.utils.reg;

public class IDArray {

    public volatile static ArrayList<reg<item>> Items = new ArrayList<>();
    public volatile static ArrayList<reg<fluid>> Fluids = new ArrayList<>();
    public volatile static ArrayList<reg<material>> Materials = new ArrayList<>();
    public volatile static ArrayList<reg<element>> Elements = new ArrayList<>();
    public volatile static ArrayList<reg<recipe>> Recipe = new ArrayList<>();
    public volatile static ArrayList<reg<machine>> Machine = new ArrayList<>();

}
