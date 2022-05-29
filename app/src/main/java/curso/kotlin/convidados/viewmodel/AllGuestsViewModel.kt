package curso.kotlin.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import curso.kotlin.convidados.service.model.GuestModel
import curso.kotlin.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    //dúvida: por q está pedindo um parâmetro se eu estou instanciando toda a função que
    //está dentro da classe GuestRepository?
    fun load() {
        mGuestList.value = mGuestRepository.getAllGuests()
    }
}