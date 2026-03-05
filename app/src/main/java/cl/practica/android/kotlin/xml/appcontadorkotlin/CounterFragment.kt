package cl.practica.android.kotlin.xml.appcontadorkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [CounterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounterFragment : Fragment() {

    private lateinit var textViewCounterFragment: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter, container, false)

        textViewCounterFragment = view.findViewById(R.id.tvCounterFragment)

        return view
    }

    fun actualizarContador(contador: Int) {
        textViewCounterFragment.text = contador.toString()
    }


}