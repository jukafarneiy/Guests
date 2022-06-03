package curso.kotlin.convidados.view.viewholder

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import curso.kotlin.convidados.R
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
        //dúvida
        binding.textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remove_guest)
                .setMessage(R.string.ask_remove)
                .setPositiveButton(R.string.remove) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancel, null)
                .show()

            true
        }

    }
}