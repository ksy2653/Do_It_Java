package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/main/input.txt"));
		
		A a = new B();
	}
}

class A{
	public A() {
		System.out.println("A");
	}
}

class B extends A{
	public B() {
		System.out.println("B");
	}
}