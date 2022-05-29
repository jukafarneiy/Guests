package curso.kotlin.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import curso.kotlin.convidados.databinding.ActivityGuestFormularyBinding
import curso.kotlin.convidados.viewmodel.GuestFormularyViewModel

class GuestFormularyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestFormularyBinding
    private lateinit var mViewModel: GuestFormularyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormularyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[GuestFormularyViewModel::class.java]

        setListeners()
        observe()

    }

    private fun setListeners() {
        binding.bttnSave.setOnClickListener {

            val name = binding.editGuestName.text.toString()
            val presence = binding.radioPresent.isChecked

            mViewModel.save(name, presence)

        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this) {
            if (it) {
                Toast.makeText(this, "Convidado salvo.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ocorreu um erro.", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}