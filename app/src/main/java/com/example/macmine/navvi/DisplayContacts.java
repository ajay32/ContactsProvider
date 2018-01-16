package com.example.macmine.navvi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DisplayContacts extends AppCompatActivity {

    TextView contactsDisplay;
    Button btn;
    ArrayList<Contact> selectedContacts = new ArrayList<>();
    private String data;
   public static String pid;
    int count=1;

//  public static  SharedPref sharedPref;

 public static String display2="";
  //  String pid=getIntent().getStringExtra("pid");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        contactsDisplay = (TextView) findViewById(R.id.txt_selected_contacts);
        btn= (Button) findViewById(R.id.btn_pick_contacts);
    //    sharedPref=new SharedPref(DisplayContacts.this);
        try{
           // pid=getIntent().getStringExtra("pid");
        }
        catch (Exception e){

            Toast.makeText(DisplayContacts.this, ""+e, Toast.LENGTH_SHORT).show();
        }






        selectedContacts = (ArrayList<Contact>) getIntent().getSerializableExtra("SelectedContacts");



        String display="";
        for(int i=0;i<selectedContacts.size();i++){

            display += (i+1)+". "+selectedContacts.get(i).toString()+"\n";
            if(i==selectedContacts.size()-1)
            display2+=selectedContacts.get(i).toString1();
            else
                display2+=selectedContacts.get(i).toString1()+",";


        }
        contactsDisplay.setText("Selected Contacts : \n\n"+display);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              //  sendInvites(display2);
              //  startActivity(new Intent(DisplayContacts.this, ProposalSummary.class));



              /*  Toast.makeText(DisplayContacts.this, "Proposal Sent", Toast.LENGTH_SHORT).show();
//                Log.e("TAG99", String.valueOf(selectedContacts));

                sendInvites(display2);
                Intent intent=new Intent(DisplayContacts.this, MainActivity.class);
                startActivity(intent);
*/



            }
        });


    }

  /*  private void sendInvites(final String contacts) {


      //  Gson gson= new Gson();
      //  data=gson.toJson(selectedContacts);


        final ProgressDialog loadingff = ProgressDialog.show(this,"Updating...","Please wait...",false,false);



        StringRequest stringRequest=new StringRequest(Request.Method.POST, Config.ApiPath,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                       //     Toast.makeText(DisplayContacts.this, response, Toast.LENGTH_SHORT).show();
                            loadingff.dismiss();

                            JSONObject jsonRootObject= new JSONObject(response);
                            Log.e("RESPONSE",response);
                            String success=jsonRootObject.getString("success");
                            String message=jsonRootObject.getString("message");
                            Toast.makeText(DisplayContacts.this, message, Toast.LENGTH_SHORT).show();

                            if(success.equalsIgnoreCase("true")) {

                                startActivity(new Intent(DisplayContacts.this, ProposalSummary.class));
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        loadingff.dismiss();

                  //      Toast.makeText(DisplayContacts.this," Please Check \n Your Connection", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("action","Insert_contuct");
                map.put("pid",pid);
                map.put("uid",sharedPref.getUserid());
                map.put("name",sharedPref.getUserName());
                map.put("contact_list",contacts);
                Log.e("TAG",map.toString());
                return  map;
            }
        };
        RetryPolicy retryPolicy=new DefaultRetryPolicy(30000,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        VolleySingleton.getInstance(DisplayContacts.this).addToRequestQueue(stringRequest);

    }*/
}
