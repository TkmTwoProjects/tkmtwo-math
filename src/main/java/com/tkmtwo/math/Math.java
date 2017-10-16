package com.tkmtwo.math;

import com.google.common.base.Splitter;
import com.google.common.io.Files;
import java.util.List;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Math {
  
  public static final Splitter COMMA_SPLITTER =
    Splitter.on(',').omitEmptyStrings().trimResults();
  
  
  public static double[][] csvXyInts(String fileName) {
    double[][] dxys = null;
    try {
      List<String> lines = FileUtils.readLines(new File(fileName));
      dxys = new double[lines.size()][2];
      
      for (int i = 0; i < lines.size(); i++) {
        List<String> xys = COMMA_SPLITTER.splitToList(lines.get(i));
        double dx = Double.parseDouble(xys.get(0));
        double dy = Double.parseDouble(xys.get(1));
        dxys[i] = new double[]{dx, dy};
      }
    } catch (Throwable t) {
      throw new RuntimeException("Could not read test data", t);
    }
    
    return dxys;
  }
  
}
