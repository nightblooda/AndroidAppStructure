package com.brainonet.brainonet.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainonet.brainonet.R

class FragmentOtp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }


}





//class FragmentOtp: AppCompatActivity(){
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_otp)
//
//        setSupportActionBar(findViewById(R.id.otp_toolbar))
//        supportActionBar?.title = "OTP"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        otp_btn.setOnClickListener{
//            openFragmentFirst()
//        }
//    }
//
//    fun openFragmentFirst(){
//        val intent = Intent(this, FragmentFirst::class.java)
//        startActivity(intent)
//    }
//}