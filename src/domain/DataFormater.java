package domain;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public interface DataFormater {
    public String format(ArrayList<Product> o);

    public ArrayList<Product> deformat(BufferedReader file);
}
