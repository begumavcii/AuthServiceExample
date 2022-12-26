package com.huawei.projects.authserviceexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.api.AGConnectApi
import com.huawei.agconnect.auth.AGConnectAuth
import com.huawei.agconnect.auth.AGConnectAuthCredential
import com.huawei.hms.support.hwid.ui.HuaweiIdAuthButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<HuaweiIdAuthButton>(R.id.btn_sign_in)
        button.setOnClickListener {
            signIn()
        }

}
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        AGConnectApi.getInstance().activityLifecycle().onActivityResult(requestCode,resultCode,data)
    }

    fun signIn(){
        AGConnectAuth.getInstance().signIn(this, AGConnectAuthCredential.HMS_Provider).addOnSuccessListener {
            Toast.makeText(this,"GIRIS BASARILI",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}