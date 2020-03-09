package com.brainonet.brainonet.ui.auth

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_mobile.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.brainonet.brainonet.R


class FragmentMobile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        otp_btn.setOnClickListener{
            openFragmentOtp()
        }

    }

    private fun openFragmentOtp(){
        findNavController().navigate(R.id.action_fragmentMobile_to_fragmentOtp)
    }
}










//
//class FragmentMobile: AppCompatActivity(){
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_mobile)
//
//        setSupportActionBar(findViewById(R.id.mobile_toolbar))
//        supportActionBar?.title = "Verify Phone Number"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        requestHint()
//
//
//        otp_btn.setOnClickListener{
//            openFragmentOtp()
//        }
//
//    }
//
//    fun openFragmentOtp(){
//        val intent = Intent(this, FragmentOtp::class.java)
//        startActivity(intent)
//    }
//
//
//
//
//        private val CREDENTIAL_PICKER_REQUEST = 1  // Set to an unused request code
//
////     Construct a request for phone numbers and show the picker
//    private fun requestHint() {
//        val hintRequest = HintRequest.Builder()
//            .setPhoneNumberIdentifierSupported(true)
//            .build()
//        val credentialsClient = Credentials.getClient(this)
//        val intent = credentialsClient.getHintPickerIntent(hintRequest)
//        startIntentSenderForResult(
//            intent.intentSender,
//            CREDENTIAL_PICKER_REQUEST,
//            null, 0, 0, 0
//        )
//    }
//
//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            CREDENTIAL_PICKER_REQUEST ->
//                // Obtain the phone number from the result
//                if (resultCode == Activity.RESULT_OK && data != null) {
//                    val credential = data.getParcelableExtra<Credential>(Credential.EXTRA_KEY)
//                    // credential.getId();  <-- will need to process phone number string
//                    mobile_number?.setText(credential.id)
//                }
//            // ...
//        }
//    }
//}