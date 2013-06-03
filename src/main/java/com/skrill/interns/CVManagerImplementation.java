package com.skrill.interns;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.csvreader.CsvWriter;

/**
 * This is the concrete implementation of the CVManager interface.
 * 
 * @author boykoarsov
 * 
 */
public class CVManagerImplementation implements CVManager {
    static Scanner in = new Scanner(System.in);

    public static String takeUserInput() {
        String str = in.nextLine();
        return str;
    }

    public void add(ArrayList<CV> CVList, CV cv) {
        PersonalInformation CVpersonalInfo = cv.getPersonalInfo();
        Address CVaddr = CVpersonalInfo.getAddress();

        System.out.print("Enter your first name: ");

        CVpersonalInfo.setFirstName(takeUserInput());
        System.out.print("Enter your last name: ");
        CVpersonalInfo.setLastName(takeUserInput());
        System.out.print("Enter your email: ");
        CVpersonalInfo.setEmail(takeUserInput());
        System.out.print("Enter your country: ");
        CVaddr.setCountry(takeUserInput());
        System.out.print("Enter your city: ");
        CVaddr.setCity(takeUserInput());
        System.out.print("Enter your street name and number: ");
        CVaddr.setAddressLine1(takeUserInput());
        System.out.print("Enter your ZIP code: ");
        CVaddr.setZip(takeUserInput());
        System.out.print("Enter your phone number: ");
        CVpersonalInfo.setPhoneNumber(takeUserInput());
        while (true) {
            System.out.print("Enter your date of birth in the format DD-MM-YYYY: ");
            // String to Date conversion in Java with dd-MM-yyyy format e.g.
            // "14-09-2011"
            String date = takeUserInput();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                CVpersonalInfo.setDateOfBirth((Date) formatter.parse(date));
                break;
            } catch (ParseException e) {
                System.out.print("Incorrect format of date entered!");
                continue;
            }
        }
        System.out.print("Enter your previous work experience: ");
        cv.setPreviousExperience(takeUserInput());
        System.out.print("Enter your education: ");
        cv.setEducation(takeUserInput());
        System.out.print("Enter the position for which you're applying: ");
        cv.setPositionToApplyFor(takeUserInput());
        cv.setSubmissionDate(new Date());
        CVList.add(cv);
    }

    public void view(ArrayList<CV> CVs) {

        if (CVs.size() > 0) {
            System.out.println("This is the list of entered CVs :");
            System.out.println("----------------------------------\n");

            for (int i = 0; i < CVs.size(); i++) {
                CV cv = CVs.get(i);
                PersonalInformation CVpersonalInfo = cv.getPersonalInfo();
                Address CVaddr = CVpersonalInfo.getAddress();

                System.out.printf("CV: (%d) \n", i + 1);
                System.out.println("********************************");
                System.out.println("First name: " + CVpersonalInfo.getFirstName());
                System.out.println("Last name: " + CVpersonalInfo.getLastName());
                System.out.println("Email: " + CVpersonalInfo.getEmail());
                System.out.println("Phone number: " + CVpersonalInfo.getPhoneNumber());
                System.out.print("Address: " + CVaddr.getCountry() + ", " + CVaddr.getCity() + ", " + ", "
                        + CVaddr.getAddressLine1() + ", " + " ZIP: " + CVaddr.getZip() + "\n");
                System.out.println("Date of birth: "
                        + new SimpleDateFormat("yyyy/MM/dd").format(CVpersonalInfo.getDateOfBirth()));
                System.out.println("Previous experience: " + cv.getPreviousExperience());
                System.out.println("Education: " + cv.getEducation());
                System.out.println("Applying for position: " + cv.getPositionToApplyFor());

                String strdate = "";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                strdate = sdf.format(cv.getSubmissionDate());
                System.out.println("Date of CV submission: " + strdate);
                System.out.println("********************************");
            }
        } else
            System.out.println("There are currently no CVs entered:");

    }

    public void view(ArrayList<CV> CVs, int order) {

        try {
            System.out.printf("CV: (%d) \n", order);
            System.out.println("----------------------------------\n");

            CV cv = CVs.get(order - 1);
            PersonalInformation CVpersonalInfo = cv.getPersonalInfo();
            Address CVaddr = CVpersonalInfo.getAddress();

            System.out.printf("CV: (%d) \n", order);
            System.out.println("********************************");
            System.out.println("First name: " + CVpersonalInfo.getFirstName());
            System.out.println("Last name: " + CVpersonalInfo.getLastName());
            System.out.println("Email: " + CVpersonalInfo.getEmail());
            System.out.println("Phone number: " + CVpersonalInfo.getPhoneNumber());
            System.out.print("Address: " + CVaddr.getCountry() + ", " + CVaddr.getCity() + ", " + ", "
                    + CVaddr.getAddressLine1() + ", " + " ZIP: " + CVaddr.getZip() + "\n");
            System.out.println("Date of birth: "
                    + new SimpleDateFormat("yyyy/MM/dd").format(CVpersonalInfo.getDateOfBirth()));
            System.out.println("Previous experience: " + cv.getPreviousExperience());
            System.out.println("Education: " + cv.getEducation());
            System.out.println("Applying for position: " + cv.getPositionToApplyFor());

            String strdate = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            strdate = sdf.format(cv.getSubmissionDate());
            System.out.println("Date of CV submission: " + strdate);
            System.out.println("********************************");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("This CV does not exist or you've entered a wrong number.");
        }

    }

    public void viewJSON(ArrayList<CV> CVs) {
        if (CVs.size() > 0) {

            for (int i = 0; i < CVs.size(); i++) {
                CV cv = CVs.get(i);
                System.out.println(cv.toString());
            }

        } else
            System.out.println("There are currently no CVs entered:");
    }

    public void mainMenu() {
        ArrayList<CV> CVList = new ArrayList<CV>();
        CVManagerImplementation cvman = new CVManagerImplementation();

        while (true) {
            System.out.println("Do you want to enter a CV? Yes or No?");
            char answer = takeUserInput().charAt(0);
            if (answer == 'y') {
                System.out.println("Enter the details for your CV below as prompted: ");
                CV cv = new CV();
                cvman.add(CVList, cv);
                answer = 'a';
            } else {
                System.out.println("Do you want to view all current CVs? Yes or No?");
                answer = takeUserInput().charAt(0);
            }
            if (answer == 'y') {
                cvman.view(CVList);
                System.out.println("All CVs in JSON format:");
                System.out.println("---------------------------");
                cvman.viewJSON(CVList);
                System.out.println("---------------------------");
                answer = 'a';
            }

            System.out.printf("Do you want to view a certain CV from a list of %d CVs? Yes or No?", CVList.size());
            answer = takeUserInput().charAt(0);
            if (answer == 'y') {
                while (true) {
                    System.out.printf("Enter a CV number from 1 to %d", CVList.size());
                    try {
                        int CVnum = Integer.parseInt(takeUserInput());
                        cvman.view(CVList, CVnum);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter an integer!");
                        continue;
                    }
                } // end validation for integer for choice for view (int)

            } // end if choice for view (int)
            System.out.println("Quit? Yes or No?");
            answer = takeUserInput().charAt(0);
            if (answer == 'y') {
                in.close();
                System.out.println("Exporting data in CSV...Done.");
                cvman.exportToCSV(CVList);
                break;
            } else
                answer = 'a';
        } // end while
    }

    public void exportToCSV(ArrayList<CV> CVs) {

        String outputFile = "CVListExport.csv";

        // before we open the file check to see if it already exists
        boolean alreadyExists = new File(outputFile).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            // if the file didn't already exist then we need to write out the
            // header line
            if (!alreadyExists) {
                csvOutput.write("First name");
                csvOutput.write("Last Name");
                csvOutput.write("Email");
                csvOutput.write("Phone Number");
                csvOutput.endRecord();
            }
            // else assume that the file already has the correct header line

            for (int i = 0; i < CVs.size(); i++) {
                CV cv = CVs.get(i);
                PersonalInformation CVpersonalInfo = cv.getPersonalInfo();

                csvOutput.write(String.format("%10s", CVpersonalInfo.getFirstName()));
                csvOutput.write(String.format("%9s", CVpersonalInfo.getLastName()));
                csvOutput.write(String.format("%5s", CVpersonalInfo.getEmail()));
                csvOutput.write(String.format("%10s", CVpersonalInfo.getPhoneNumber()));
                csvOutput.endRecord();
            }
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}