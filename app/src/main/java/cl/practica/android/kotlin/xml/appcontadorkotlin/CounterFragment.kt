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


    companion object {

        @JvmStatic
        fun newInstance(contador: Int): CounterFragment{
            val fragment = CounterFragment()
            val args = Bundle()
            args.putInt("valor_contador", contador)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter, container, false)

        var contadorRecibido = arguments?.getInt("valor_contador")?:0

        actualizarContador(contadorRecibido)

        return view
    }

    fun actualizarContador(contador: Int) {
        if (view != null){
            var textViewCounterFragment: TextView = requireView().findViewById(R.id.tvCounterFragment)
            textViewCounterFragment.text = contador.toString()
        }

    }


}