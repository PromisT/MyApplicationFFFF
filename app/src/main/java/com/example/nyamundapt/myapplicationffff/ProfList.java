package com.example.nyamundapt.myapplicationffff;

import java.io.Serializable;

/**
 * Created by CodeTribe on 10/17/2017.
 */
public class ProfList implements Serializable {


    private String childsName;
    private String childsSurname;
    private String childsAge;
    private String childsDob;
    private String childsFavmeal;
    private String childsAllergies;
    private String childsAddress;
    private String childsPname;
    private String childsPcontact;
    private int photo;



    public ProfList(String eclnmEditText, String eeditTextname, String esurnameEditText, String eageEditText, String edateEditText, String emealEditText, String eallergiesEditText, String eaddressEditText, String epnameEditText, String econtactsEditText, int pictt)
    {

    }

    public ProfList(String childsName, String childsSurname, String childsAge, String childsDob, String childsFavmeal, String childsAllergies,
                    String childsAddress, String childsPname, String childsPcontact, int photo) {
        this.childsName = childsName;
        this.childsSurname = childsSurname;
        this.childsAge = childsAge;
        this.childsDob = childsDob;
        this.childsFavmeal = childsFavmeal;
        this.childsAllergies = childsAllergies;
        this.childsAddress = childsAddress;
        this.childsPname = childsPname;
        this.childsPcontact = childsPcontact;
        this.photo = photo;
    }

    public void setChildsName(String childsName) {
        this.childsName = childsName;
    }
    public void setChildsSurname(String childsSurname) {
        this.childsSurname = childsSurname;
    }
    public void setChildsAge(String childsAge) {
        this.childsAge = childsAge;
    }
    public void setChildsDob(String childsDob) {
        this.childsDob = childsDob;
    }
    public void setChildsFavmeal(String childsFavmeal) {
        this.childsFavmeal = childsFavmeal;
    }
    public void setChildsAllergies(String childsAllergies) {
        this.childsAllergies = childsAllergies;
    }
    public void setChildsAddress(String childsAddress) {
        this.childsAddress = childsAddress;
    }
    public void setChildsPname(String childsPname) {
        this.childsPname = childsPname;
    }
    public void setChildsPcontact(String childsPcontact) {
        this.childsPcontact = childsPcontact;
    }
    public void setPhoto(int photo){this.photo = photo;}

    public String getChildsName() {
        return childsName;
    }

    public String getChildsSurname() {
        return childsSurname;
    }

    public String getChildsAge() {
        return childsAge;
    }

    public String getChildsDob() {
        return childsDob;
    }

    public String getChildsFavmeal() {
        return childsFavmeal;
    }

    public int getPhoto(){return photo;}

    public String getChildsAllergies() {
        return childsAllergies;
    }

    public String getChildsAddress() {
        return childsAddress;
    }

    public String getChildsPname() {
        return childsPname;
    }

    public String getChildsPcontact() {
        return childsPcontact;
    }

}
