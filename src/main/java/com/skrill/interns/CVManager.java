package com.skrill.interns;

import java.util.ArrayList;

/**
 * 
 * @author boykoarsov This is an interface that declares the operations that are
 *         applicable for the CV application.
 */
public interface CVManager {
    /**
     * Adds a CV with all its fields in the object that stores the CVs.
     * 
     * @param CVList
     *            Holds a reference to the object that stores CVs in memory - in
     *            this care it is ArrayList.
     * @param cv
     *            Reference to the CV to be added.
     */
    public void add(ArrayList<CV> CVList, CV cv);

    /**
     * Allows the user to view all CVs added so far in the storage object.
     * 
     * @param CVs
     *            Holds a reference to the object that stores CVs in memory - in
     *            this care it is ArrayList
     */
    public void view(ArrayList<CV> CVs);

    /**
     * 
     * @param CVs
     *            Holds a reference to the object that stores CVs in memory - in
     *            this care it is ArrayList
     * @param order
     *            This variable tells the program to pull out a certain CV from
     *            the storage object. CVs are stored as they added so int order
     *            of 2 means that the second added CV will be shown.
     */
    public void view(ArrayList<CV> CVs, int order);

    public void exportToCSV(ArrayList<CV> CVs);

}
