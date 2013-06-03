package com.skrill.interns;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author boykoarsov This is a class that models a person's CV and contains
 *         information that is typically found in CVs.
 */
public class CV {
    /**
     * @see PersonalInformation Reference to the class that holds personal
     *      information such as names, email, etc.
     */
    private PersonalInformation personalInfo;
    private String previousExperience;
    private String education;
    /**
     * Stores a string representing the position that the CV is applied for.
     */
    private String positionToApplyFor;
    private Date submissionDate;

    public CV() {
        personalInfo = new PersonalInformation();
        previousExperience = "";
        education = "";
        positionToApplyFor = "";
        submissionDate = new Date();

    }

    public PersonalInformation getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getPreviousExperience() {
        return previousExperience;
    }

    public void setPreviousExperience(String previousExperience) {
        this.previousExperience = previousExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPositionToApplyFor() {
        return positionToApplyFor;
    }

    public void setPositionToApplyFor(String positionToApplyFor) {
        this.positionToApplyFor = positionToApplyFor;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date date) {
        this.submissionDate = date;
    }

    public String toString() {
        return String
                .format(" {\"CV Application\" : {%s, \"previousExperience\" : \"%s\", \"education\" : \"%s\", \"positionToApplyFor\" : \"%s\", \"submissionDate\" : \"%s\"} ",
                        personalInfo.toString(), previousExperience, education, positionToApplyFor,
                        new SimpleDateFormat("yyyy/MM/dd").format(submissionDate));
    }
}
