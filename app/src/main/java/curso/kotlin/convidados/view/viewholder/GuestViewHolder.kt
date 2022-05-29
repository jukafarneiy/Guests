package curso.kotlin.convidados.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import curso.kotlin.convidados.databinding.RowGuestBinding
import curso.kotlin.convidados.service.model.GuestModel

class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private lateinit var binding: RowGuestBinding

    fun bind(guest: GuestModel) {
        binding.textName.text = guest.name
    }

}