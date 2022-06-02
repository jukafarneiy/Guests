package curso.kotlin.convidados.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import curso.kotlin.convidados.databinding.RowGuestBinding
import curso.kotlin.convidados.service.model.GuestModel
import curso.kotlin.convidados.view.listener.GuestListener

class GuestViewHolder(private var binding: RowGuestBinding, private val listener: GuestListener) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(guest: GuestModel) {
        binding.textName.text = guest.name

        binding.textName.setOnClickListener {
            listener.onClick(guest.id)
        }
    }
}