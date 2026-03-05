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

        binding.buttonIncrement.setOnClickListener {
            contador ++
            binding.textViewCounter.text = contador.toString()
        }

        binding.buttonDecrement.setOnClickListener {
            if (contador > 0 ){
                contador --
                binding.textViewCounter.text = contador.toString()
            }

        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment)
                .commit()
        }
        fragment.actualizarContador(contador)
    }


}