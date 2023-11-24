package com.example.easygrade.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.easygrade.R
import com.example.easygrade.databinding.ActivityCadastroDisciplinaBinding


class CadastroDisciplinaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroDisciplinaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroDisciplinaBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val spinner: Spinner = findViewById(R.id.edtDificuldade)
        ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}