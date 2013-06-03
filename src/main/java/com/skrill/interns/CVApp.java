package com.skrill.interns;

/**
 * This is the main() class that uses the implementation of CVManager to add and
 * view CVs via a simple command-line UI.
 * 
 * @author boykoarsov
 * 
 * 
 */
public class CVApp {
    /*
     * public static String takeUserInput() { Scanner in = new
     * Scanner(System.in); String str = in.nextLine(); in.close(); return str; }
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        CVManagerImplementation cvman = new CVManagerImplementation();
        cvman.mainMenu();
    }

}
