package cl.practica.android.kotlin.xml.appcontadorkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cl.practica.android.kotlin.xml.appcontadorkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment: CounterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fragment = CounterFragment.newInstance(contador)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment)
            .commit()

        if (savedInstanceState != null){
            contador = savedInstanceState.getInt("contador_guardado", 0)
            fragment.actualizarContador(contador)
        }



        binding.textViewCounter.text = contador.toString()


        binding.buttonIncrement.setOnClickListener {
            contador++
            binding.textViewCounter.text = contador.toString()
            fragment.actualizarContador(contador)
        }

        binding.buttonDecrement.setOnClickListener {
            if (contador > 0) {
                contador--
                binding.textViewCounter.text = contador.toString()
                fragment.actualizarContador(contador)
            }

        }





    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador_guardado", contador)
    }

}