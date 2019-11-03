package example.official.reshan.assignment2_phd19006;

import androidx.fragment.app.Fragment;

public class Contact extends Fragment {
    private String Name;
    private String Phone;
    private int Photo;

    //Constructor

    public Contact(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }
    //getter

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return Photo;
    }

    //setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}


