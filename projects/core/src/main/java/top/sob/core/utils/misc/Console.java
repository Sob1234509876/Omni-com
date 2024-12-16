package top.sob.core.utils.misc;

import java.io.PrintWriter;
import java.util.Scanner;

public interface Console {

    PrintWriter getOut();

    PrintWriter getErr();

    Scanner getIn();

    boolean supportANSI();

}
