package curso.kotlin.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import curso.kotlin.convidados.service.model.GuestModel
import curso.kotlin.convidados.service.repository.GuestRepository

class AbsentGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestAbsentList: LiveData<List<GuestModel>> = mGuestList

    fun loadAbsents() {
        mGuestList.value = mGuestRepository.getAbsentGuests()

    }
}