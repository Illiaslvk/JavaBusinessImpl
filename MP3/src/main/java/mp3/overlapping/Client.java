package mp3.overlapping;

import mp3.BookValidation;
import mp3.NullValidation;

import java.util.EnumSet;

public class Client implements Employee,Student,Researcher{

    private String name;
    private int age;
    private String phoneNumber;
    private boolean alreadyBooked;

    private EnumSet<ClientType> clientTypes;

    //Employee
    private String email;
    private String apartAddress;

    //Student
    private String yearOfStudy;
    private int studentID;

    //Researcher
    private String affiliation; // членство в бібліотеці
    private String researchField;

    public Client(EnumSet<ClientType> clientTypes, String name, int age, String phoneNumber, boolean alreadyBooked,
                  String email, String apartAddress,
                  String yearOfStudy, int studentID,
                  String affiliation, String researchField) {
        setClientTypes(clientTypes);
        setName(name);
        setAge(age);
        setPhoneNumber(phoneNumber);
        setAlreadyBooked(alreadyBooked);
        //attributes for emp
        if (clientTypes.contains(ClientType.Employee)){
            setEmail(email);
            setApartAddress(apartAddress);
        }
        //attributes for student
        if (clientTypes.contains(ClientType.Student)){
            setYearOfStudy(yearOfStudy);
            setStudentID(studentID);
        }
        //attributes for researcher
        if (clientTypes.contains(ClientType.Researcher)){
            setAffiliation(affiliation);
            setResearchField(researchField);
        }

    }

    // Name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new NullValidation("Name cannot be null!!!");
        }
        this.name = name;
    }

    // Age

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if((Integer)age == null) {
            throw new NullValidation("Age cannot be null!!!");
        } else if(age < 10) {
            throw new BookValidation("Client too young!");
        }
        this.age = age;
    }

    // Phone number

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()) {
            throw new NullValidation("Phone Number cannot be null!!!");
        }
        this.phoneNumber = phoneNumber;
    }

    // Already booked

    public void setAlreadyBooked(boolean alreadyBooked) {
        this.alreadyBooked = alreadyBooked;
    }

    //Email

    @Override
    public String getEmail() {
        if(isEmployee()) {
            return email;
        }
        throw new BookValidation("This object does not have property requested");
    }

    @Override
    public void setEmail(String email) {
        if(isEmployee()) {
            if(email == null || email.isBlank()) {
                throw new NullValidation("Email cannot be null!!!");
            }
            this.email = email;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    // Apart address
    @Override
    public String getApartAddress() {
        if(isEmployee()){
            return apartAddress;
        }
        throw new BookValidation("This object does not have property requested");
    }

    @Override
    public void setApartAddress(String apartAddress) {
        if(isEmployee()) {
            if(apartAddress == null || apartAddress.isBlank()) {
                throw new NullValidation("Apart address cannot be null!!!");
            }
            this.apartAddress = apartAddress;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    //Year of study

    @Override
    public String getYearOfStudy() {
        if(isStudent()) {
            return yearOfStudy;
        }
        throw new BookValidation("This object does not have property requested");
    }

    @Override
    public void setYearOfStudy(String yearOfStudy) {
        if(isStudent()) {
            if(yearOfStudy == null || yearOfStudy.isBlank()){
                throw new NullValidation("Year of study cannot be null!!");
            }
            this.yearOfStudy = yearOfStudy;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    // Student ID

    @Override
    public int getStudentID() {
        if(isStudent()) {
            return studentID;
        }
        throw new BookValidation("This object does not have property requested");
    }
    @Override
    public void setStudentID(int studentID) {
        if(isStudent()) {
            if((Integer)studentID == null) {
                throw new NullValidation("Student ID can not be null!!");
            }
            this.studentID = studentID;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    // Affiliation
    @Override
    public String getAffiliation() {
        if(isResearcher()) {
            return affiliation;
        }
        throw new BookValidation("This object does not have property requested");
    }
    @Override
    public void setAffiliation(String affiliation) {
        if(isResearcher()) {
            if (affiliation == null || affiliation.isBlank()) {
                throw new NullValidation("Affiliation can not be null!!");
            }
            this.affiliation = affiliation;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    // Research field
    @Override
    public String getResearchField() {
        if(isResearcher()) {
            return researchField;
        }
        throw new BookValidation("This object does not have property requested");
    }
    @Override
    public void setResearchField(String researchField) {
        if(isResearcher()) {
            if (researchField == null || researchField.isBlank()) {
                throw new NullValidation("Research Field can not be null!!");
            }
            this.researchField = researchField;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    //Methods

    private boolean isStudent() {
        return clientTypes.contains(ClientType.Student);
    }

    private boolean isEmployee() {
        return clientTypes.contains(ClientType.Employee);
    }

    private boolean isResearcher() {
        return clientTypes.contains(ClientType.Researcher);
    }

    public EnumSet<ClientType> getClientTypes() {
        return clientTypes;
    }

    //put it private
    private void setClientTypes(EnumSet<ClientType> clientType) {
        if (clientType == null || clientType.size() == 0){
            throw new NullValidation("Client types cannot be empty!");
        }
        if(clientTypes == null) {
            clientTypes = EnumSet.copyOf(clientType);
        }
    }

}