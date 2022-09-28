package `in`.upride.client.ds

import `in`.upride.client.ds.ui.ClientProfile
import `in`.upride.client.ds.ui.PhoneAuthentication
import `in`.upride.client.ds.ui.activities.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()


        if(FirebaseAuth.getInstance().currentUser == null ){
            startActivity(Intent(this@Splash, PhoneAuthentication::class.java))
        }

        FirebaseDatabase.getInstance().reference.child("app_rules")
            .child("enable_app").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val isEnabled: Boolean = snapshot.getValue() as Boolean
                    if (isEnabled) {
                        val intent: Intent = Intent(this@Splash, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("Error", error.message)
                }
            })

    }


}