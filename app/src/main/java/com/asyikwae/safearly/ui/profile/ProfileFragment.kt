package com.asyikwae.safearly.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.asyikwae.safearly.R
import com.asyikwae.safearly.auth.AuthActivity
import com.asyikwae.safearly.databinding.ProfileFragmentBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var binding: ProfileFragmentBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        requireActivity().run { googleSignInClient = GoogleSignIn.getClient(this,gso) }

        binding.name.text = currentUser?.displayName
        binding.email.text = currentUser?.email

        Glide.with(this)
            .load(currentUser?.photoUrl)
            .transform(RoundedCorners(8))
            .into(binding.avatar)

        binding.btnLogout.setOnClickListener {
            requireActivity().run {
                val eBuilder = AlertDialog.Builder(this)
                eBuilder.setTitle("Keluar")
                eBuilder.setMessage("Yakin kamu ingin keluar?")
                eBuilder.setPositiveButton("Iya") {
                        _, _ ->
                    mAuth.signOut()
                    googleSignInClient.signOut().addOnCompleteListener {
                        startActivity(Intent(this, AuthActivity::class.java))
                        finish()
                    }
                }
                eBuilder.setNegativeButton("No") {
                        _, _ ->
                    Toast.makeText(this,"yuhu gajadi keluar", Toast.LENGTH_SHORT).show()
                }
                val createBuild = eBuilder.create()
                createBuild.show()
            }
        }
    }
}