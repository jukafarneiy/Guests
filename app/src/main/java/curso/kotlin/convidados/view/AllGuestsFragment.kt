package curso.kotlin.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import curso.kotlin.convidados.databinding.FragmentAllBinding
import curso.kotlin.convidados.service.constants.GuestConstants
import curso.kotlin.convidados.view.adapter.GuestAdapter
import curso.kotlin.convidados.view.listener.GuestListener
import curso.kotlin.convidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {
    private lateinit var allGuestsViewModel: AllGuestsViewModel

    private lateinit var mListener: GuestListener

    private val mAdapter: GuestAdapter = GuestAdapter()

    private var _binding: FragmentAllBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        allGuestsViewModel =
            ViewModelProvider(this)[AllGuestsViewModel::class.java]

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //RecyclerView

        //1 - Obter o RecyclerView
        val recycler = binding.recyclerAllGuests

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
        }

        mAdapter.attachListener(mListener)
        observerAllGuests()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestsViewModel.loadAll()
    }

    private fun observerAllGuests() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner) {
            mAdapter.updateGuests(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}