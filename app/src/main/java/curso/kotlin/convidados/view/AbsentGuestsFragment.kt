package curso.kotlin.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import curso.kotlin.convidados.databinding.FragmentAbsentBinding
import curso.kotlin.convidados.service.constants.GuestConstants
import curso.kotlin.convidados.view.adapter.GuestAdapter
import curso.kotlin.convidados.view.listener.GuestListener
import curso.kotlin.convidados.viewmodel.AllGuestsViewModel

class AbsentGuestsFragment : Fragment() {

    private lateinit var mViewModel: AllGuestsViewModel
    private lateinit var mListener: GuestListener
    private val mAdapter: GuestAdapter = GuestAdapter()

    private var _binding: FragmentAbsentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        mViewModel =
            ViewModelProvider(this)[AllGuestsViewModel::class.java]

        _binding = FragmentAbsentBinding.inflate(inflater, container, false)
        //RecyclerView

        //1 - Obter o RecyclerView
        val recycler = binding.recyclerAbsentGuests

        //2 - Definir um layout pro RecyclerView
        recycler.layoutManager = LinearLayoutManager(context)

        //3 - Definir um adapter
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormularyActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.loadAll(GuestConstants.FILTERS.ABSENTS)
            }
        }

        mAdapter.attachListener(mListener)
        observerAllGuests()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadAll(GuestConstants.FILTERS.ABSENTS)
    }

    private fun observerAllGuests() {
        mViewModel.guestList.observe(viewLifecycleOwner) {
            mAdapter.updateGuests(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}