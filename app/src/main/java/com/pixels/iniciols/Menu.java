package com.pixels.iniciols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Menu extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String Nombre_C=acct.getDisplayName();
            String Email_C=acct.getEmail();
            Toast.makeText(this, "Nombre: "+Nombre_C+"  Email:"+Email_C, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "No se Pudo Conectar a Google o Se Perdio la Conexion de Internet", Toast.LENGTH_SHORT).show();
        }
    }

}