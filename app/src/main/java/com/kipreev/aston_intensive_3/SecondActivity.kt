package com.kipreev.aston_intensive_3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {
    private lateinit var urlImage: String
    private lateinit var inputLink: EditText
    private lateinit var containerImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        inputLink = findViewById(R.id.input_link)
        containerImage = findViewById(R.id.container_image)

        urlImage = savedInstanceState?.getString(KEY).toString()

        inputLink.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                urlImage = inputLink.text.toString()
                downLoadWithCoil(urlImage)
            }
        })


        inputLink.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                urlImage = inputLink.text.toString()
                downLoadWithPicasso(urlImage)
            }
        })

        inputLink.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                urlImage = inputLink.text.toString()
                downLoadWithGlide(urlImage)
            }
        })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, urlImage)
    }


    private fun downLoadWithCoil(link: String?) {
        val valid = validateInput(link.toString())
        if (valid) {
            val trimLink = parseLink(link.toString())
            containerImage.load(trimLink)
        } else {
            Toast.makeText(this, "Wrong link", Toast.LENGTH_SHORT).show()
        }
    }

    private fun downLoadWithPicasso(link: String) {
        val valid = validateInput(link.toString())
        if (valid) {
            val trimLink = parseLink(link.toString())
            Picasso.get().load(trimLink).into(containerImage)
        } else {
            Toast.makeText(this, "Wrong link", Toast.LENGTH_SHORT).show()
        }
    }

    private fun downLoadWithGlide(link: String) {
        val valid = validateInput(link.toString())
        if (valid) {
            val trimLink = parseLink(link.toString())
            Glide.with(this).load(trimLink).into(containerImage)
        } else {
            Toast.makeText(this, "Wrong link", Toast.LENGTH_SHORT).show()
        }
    }


    private fun parseLink(inputLink: String?): String {
        return inputLink?.trim() ?: ""
    }

    private fun validateInput(link: String): Boolean {
        var result = true
        if (link.isBlank()) {
            result = false
        }
        return result
    }

    companion object {
        private const val KEY = "key for save"
    }
}