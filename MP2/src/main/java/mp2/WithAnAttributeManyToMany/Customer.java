package mp2.WithAnAttributeManyToMany;

// With an attribute

import mp2.Validation.NullValidation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String firstName;
    private String lastName;
    private Set<Purchase> purchases = new HashSet<>();

    public Customer(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
    ////////////////////Getters and Setters////////////////////
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public Set<Purchase> getPurchases() {
        return Collections.unmodifiableSet(purchases);
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullValidation("firstName can not be empty");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullValidation("lastName can not be empty");
        }
        this.lastName = lastName;
    }

    // add & remove
    public void addPurchases(Purchase purchase) {
        if (purchase == null) {
            throw new NullValidation("Can not be null");
        } else if (purchases.contains(purchase)) {
            throw new NullValidation("The customer has already made a purchase for this book.");
        } else if (purchase.getCustomer() != this) {
            throw new NullValidation("This purchase does not pertain to this customer.");
        }
        this.purchases.add(purchase);
    }

    public void removePurchases(Purchase purchase) {
        if (purchase == null) {
            throw new NullValidation("Purchase argument can not be null");
        } else if (!purchases.contains(purchase)) {
            throw new IllegalArgumentException("The customer has not made a purchase for this book.");
        }else{
            this.purchases.remove(purchase);
            purchase.remove();
        }
    }

    //To string
    @Override
    public String toString() {
        return "Customer{" + "FirstName =" + firstName + "LastName = " + lastName + "\n" +  "CustomerPurchases = " + purchases + '}';
    }
}

