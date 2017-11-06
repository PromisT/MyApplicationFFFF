package com.example.nyamundapt.myapplicationffff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegisterLearners extends AppCompatActivity {

    private static final int ACTION_CODE = 1;
    private StorageReference storageReference;
    DatabaseReference databaseReference;
    ImageView imageBView;
    // EditText imageName;
    TextView btnUploadImage;
    Uri imageUri;

    public static final String Storage_Path ="image/";
    public static final String Database_Path ="image";

    public static final int Request_code =1234;


    //  EditText Ename, Edescription;
    //String eName, eDescription;
    EditText clnmEditText,editTextname, surnameEditText, ageEditText, dateEditText, mealEditText, allergiesEditText, addressEditText, pnameEditText, contactsEditText;
    String eclnmEditText,eeditTextname, esurnameEditText, eageEditText, edateEditText, emealEditText, eallergiesEditText, eaddressEditText, epnameEditText, econtactsEditText;
    int pictt;
    Button save;
    Boolean val = true;

    FirebaseDatabase firebaseData;
    DatabaseReference roofdef, demodef;
    ListView listview;
    List<ProfList> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_file);

        imageBView = (ImageView) findViewById(R.id.profilepicture);
        listview = (ListView) findViewById(R.id.listView0);
        save = (Button) findViewById(R.id.save);

        profileList = new ArrayList<>();

        clnmEditText = (EditText) findViewById(R.id.clnmEditText);
        editTextname = (EditText) findViewById(R.id.editTextname);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        ageEditText = (EditText) findViewById(R.id.ageEditText);
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        mealEditText = (EditText) findViewById(R.id.mealEditText);
        allergiesEditText = (EditText) findViewById(R.id.allergiesEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        pnameEditText = (EditText) findViewById(R.id.pnameEditText);
        contactsEditText = (EditText) findViewById(R.id.contactsEditText);

//        databaseReference = FirebaseDatabase.getInstance().getReference();
//
        storageReference = FirebaseStorage.getInstance().getReference();

        roofdef = FirebaseDatabase.getInstance().getReference();

        demodef = roofdef.child("Proofile");

        // select image
        imageBView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, ACTION_CODE);
            }
        });
    }

    public void Save(View view){
        addProfile();
        Intent intent = new Intent(RegisterLearners.this, ProfileActivity.class);
        intent.putExtra("list", (Serializable) profileList);
        startActivity(intent);
    }

    private void addProfile() {

        ProfList profList = new ProfList(eclnmEditText, eeditTextname, esurnameEditText, eageEditText, edateEditText, emealEditText, eallergiesEditText, eaddressEditText, epnameEditText, econtactsEditText, pictt);
        eclnmEditText = clnmEditText.getText().toString().trim();
        eeditTextname = editTextname.getText().toString().trim();
        esurnameEditText = surnameEditText.getText().toString().trim();
        eageEditText = ageEditText.getText().toString().trim();
        edateEditText = dateEditText.getText().toString().trim();
        emealEditText = mealEditText.getText().toString().trim();
        eallergiesEditText = allergiesEditText.getText().toString().trim();
        eaddressEditText = addressEditText.getText().toString().trim();
        epnameEditText = pnameEditText.getText().toString().trim();
        econtactsEditText = contactsEditText.getText().toString().trim();

        if (!TextUtils.isEmpty(eclnmEditText)) {
            profList.setChildsName(eclnmEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Class Name not saved ", Toast.LENGTH_LONG).show();
        }
        if (!TextUtils.isEmpty(eeditTextname)) {
            profList.setChildsName(eeditTextname);

        } else {
            Toast.makeText(RegisterLearners.this, "Name not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(esurnameEditText)) {
            profList.setChildsSurname(esurnameEditText);


        } else {
            Toast.makeText(RegisterLearners.this, "No Surname", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(eageEditText)) {
            profList.setChildsAge(eageEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Age not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(edateEditText)) {
            profList.setChildsDob(edateEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Date of Birth not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(emealEditText)) {
            profList.setChildsFavmeal(emealEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Fav Meal not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(eallergiesEditText)) {
            profList.setChildsAllergies(eallergiesEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Allergies not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(eaddressEditText)) {
            profList.setChildsAddress(eaddressEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Address not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(epnameEditText)) {
            profList.setChildsPname(epnameEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Parent name not saved ", Toast.LENGTH_LONG).show();
        }

        if (!TextUtils.isEmpty(econtactsEditText)) {
            profList.setChildsPcontact(econtactsEditText);

        } else {
            Toast.makeText(RegisterLearners.this, "Contacts not saved ", Toast.LENGTH_LONG).show();
        }


        ProfList prof = new ProfList(eclnmEditText,eeditTextname,esurnameEditText,eageEditText,edateEditText,emealEditText,eallergiesEditText,eaddressEditText,epnameEditText,econtactsEditText,pictt);
        demodef.push().setValue(prof);

        clnmEditText.setText("");
        editTextname.setText(" ");
        surnameEditText.setText(" ");
        ageEditText.setText(" ");
        dateEditText.setText(" ");
        mealEditText.setText(" ");
        allergiesEditText.setText(" ");
        addressEditText.setText(" ");
        pnameEditText.setText(" ");
        contactsEditText.setText(" ");

        try {


        } catch (Exception e) {
            val = false;
        } finally {
            if (val) {
                Toast.makeText(RegisterLearners.this, "Profile saved ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(RegisterLearners.this, "Profile not saved ", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTION_CODE && resultCode == RESULT_OK){
            imageUri = data.getData();
            imageBView.setImageURI(imageUri);
        }
    }

public void uploadImage(){

    StorageReference filePath = storageReference.child("imagess").child(imageUri.getLastPathSegment());
    filePath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            @SuppressWarnings("VisibleForTests") Uri uriImage = taskSnapshot.getDownloadUrl();

//
//            ImagePojo image = new ImagePojo();
//            image.setUrl(uriImage.toString());
//            databaseReference.child("image").push().setValue(image);
        }
    });



}
    }


