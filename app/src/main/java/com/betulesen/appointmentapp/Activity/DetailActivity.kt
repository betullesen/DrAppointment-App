package com.betulesen.appointmentapp.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.betulesen.appointmentapp.Model.DoctorsModel
import com.betulesen.appointmentapp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : BaseActivity() {

    private lateinit var binding:ActivityDetailBinding
    private lateinit var item:DoctorsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()

    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        binding.apply {
            nameDetailText.text = item.Name
            specialityDetailText.text = item.Special
            patientValue.text = item.Patiens
            bioText.text = item.Biography
            addressText.text = item.Address
            experienceValue.text = item.Experiense.toString()+" Years"
            ratingValue.text = "${item.Rating}"

            backButton.setOnClickListener{finish()}

            websiteButton.setOnClickListener{
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.site))
                startActivity(i)
            }

            messageButton.setOnClickListener{
                val uri = Uri.parse("smsto:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SENDTO,uri)
                intent.putExtra("sms_body","the SMS text")
                startActivity(intent)
            }



            callButton.setOnClickListener{
                val uri ="tel:"+item.Mobile.trim()
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse(uri)
                )
                startActivity(intent)
            }

            directionButton.setOnClickListener{
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item.Location)
                )
                startActivity(intent)
            }

            shareButton.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT,item.Name)
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    item.Name +" "+item.Address+" "+item.Mobile
                )
                startActivity(Intent.createChooser(intent,"Choose one"))
            }
            Glide.with(this@DetailActivity)
                .load(item.Picture)
                .into(imgDoc)


        }
    }
}