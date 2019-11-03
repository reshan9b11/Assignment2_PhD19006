package example.official.reshan.assignment2_phd19006;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {


    private RecyclerView myrecyclerview;
    private List<Contact> lstContact;
    public List<String> name1=new ArrayList<>();
    DBHelper mydb;
    public List<String> number1=new ArrayList<>();

    //MainActivity list_show=new MainActivity();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.contact_fragment,container,false);
        myrecyclerview=(RecyclerView)v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
//        GetList1();
//        GetList2();

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDetails();
        mydb = new DBHelper(getActivity());

        for(int i=0;i<100;i++){
            if(mydb.insertContact(name1.get(i), number1.get(i))){
                Log.d("inseted","inseted");
            }
        }

        lstContact =new ArrayList<>();
        for(int i=0;i<100;i++){
            lstContact.add(new Contact(name1.get(i),number1.get(i),R.drawable.fg));
        }
//

    }
//    public void GetList1(){
//         name1=list_show.GetList_Name();
//    }
//    public void GetList2(){
//        number1=list_show.GetList_Number();
//    }

    public void getDetails(){
        lstContact =new ArrayList<>();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ContentResolver cr = getActivity().getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
        String[] projection    = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER };
        Cursor names = getActivity().getContentResolver().query(uri, projection, null, null, null);
        int indexName = names.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int indexNumber = names.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        names.moveToFirst();
        int i=100;
        do {
            i--;
            String name   = names.getString(indexName);
            name1.add(name);
            Log.e("Name new:", name);
            String number = names.getString(indexNumber);

            number1.add(number);
            Log.e("Number new:","::"+number);
            // lstContact.add((new Contact(name,number,R.drawable.fg)));
        } while (names.moveToNext() && i>0);
    }


    //public List<String> GetList_Name(){
//
//        return name11;
//    }
//    public List<String> GetList_Number(){
//
//        return number11;
//    }
}
