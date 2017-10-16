package com.tkmtwo.math;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Arrays;

import org.apache.commons.math3.stat.regression.SimpleRegression;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleRegressionTest {
  
  //@Test
  public void testThis() { 
    System.out.println("Hello World");
    System.out.println(System.getProperty("user.dir"));
  }
  
  //@Test
  public void test0001ReadTest() {
    double[][] xys = Math.csvXyInts("build/resources/test/00-test.csv");
    System.out.println("BEGIN");
    System.out.println(Arrays.deepToString(xys));
    System.out.println("END");
  }
  
  //@Test
  public void test0001Test() {
    double[][] xys = Math.csvXyInts("build/resources/test/00-test.csv");
    SimpleRegression sr = new SimpleRegression(true);
    sr.addData(xys);
    System.out.println("TEST slope = " + sr.getSlope());
    System.out.println("TEST intercept = " + sr.getIntercept());
    
  }
  
  
  @Test
  public void test0002All() {
    String[] ss = new String[] {
      "00-test",
      "01-link1",
      "02-link2",
      "03-link3"
    };
    
    for (String s : ss) {
      double[][] xys = Math.csvXyInts("build/resources/test/" + s + ".csv");
      SimpleRegression sr = new SimpleRegression(true);
      sr.addData(xys);
      
      System.out.println();
      System.out.println(s + " slope = " + sr.getSlope());
      System.out.println(s + " intercept = " + sr.getIntercept());
    }
  }
  
  
}
