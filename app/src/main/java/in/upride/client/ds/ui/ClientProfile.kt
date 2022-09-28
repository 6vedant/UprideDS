package `in`.upride.client.ds.ui

import `in`.upride.client.ds.R
import `in`.upride.client.ds.databinding.ActivityClientProfileBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ClientProfile : AppCompatActivity() {
    private lateinit var binding: ActivityClientProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClientProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}