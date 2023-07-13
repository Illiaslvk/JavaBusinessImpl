package mp3.dynamic;

import mp3.BookValidation;
import mp3.NullValidation;

public class Client implements Employee, Student {

    private String name;
    private int age;
    private String phoneNumber;
    private boolean alreadyBooked;

    private ClientType clientTypes;

    //Employee
    private String email;
    private String apartAddress;

    //Student
    private String yearOfStudy;
    private Integer studentID;

    public Client(ClientType clientTypes, String name, int age,
                  String phoneNumber, boolean alreadyBooked, String email,
                  String apartAddress, String yearOfStudy, Integer studentID){
        setClientTypes(clientTypes);
        setName(name);
        setAge(age);
        setPhoneNumber(phoneNumber);
        setAlreadyBooked(alreadyBooked);
        //Employee
        if(clientTypes == ClientType.Employee){
            setEmail(email);
            setApartAddress(apartAddress);
        }
        //Student
        if (clientTypes == ClientType.Student){
            setYearOfStudy(yearOfStudy);
            setStudentID(studentID);
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
    public Integer getStudentID() {
        if(isStudent()) {
            return studentID;
        }
        throw new BookValidation("This object does not have property requested");
    }

    @Override
    public void setStudentID(Integer studentID) {
        if(isStudent()) {
            if(studentID == null) {
                throw new NullValidation("Student ID cannot be null!!!!");
            }
            this.studentID = studentID;
            return;
        }
        throw new BookValidation("This object does not have property requested");
    }

    // Client Type

    public ClientType getClientTypes() {
        return clientTypes;
    }

    public void setClientTypes(ClientType clientTypes) {
        if(clientTypes == null) {
            throw new NullValidation("Client type cannot be null");
        }
        this.clientTypes = clientTypes;
    }

    //Methods

    private boolean isStudent() {
        return clientTypes.equals(ClientType.Student);
    }

    private boolean isEmployee() {
        return clientTypes.equals(ClientType.Employee);
    }

    public void becomeEmployee(String email, String apartAddress){
        if (clientTypes == ClientType.Employee){
            return;
        }
        if (clientTypes == ClientType.Student){
            yearOfStudy = null;
            studentID =null;
        }
        setClientTypes(ClientType.Employee);
        setEmail(email);
        setApartAddress(apartAddress);
    }
    public void becomeStudent(String yearOfStudy, int studentID){
        if (clientTypes == ClientType.Student){
            return;
        }
        if (clientTypes == ClientType.Employee){
            email = null;
            apartAddress = null;
        }
        setClientTypes(ClientType.Student);
        setYearOfStudy(yearOfStudy);
        setStudentID(studentID);
    }

}
