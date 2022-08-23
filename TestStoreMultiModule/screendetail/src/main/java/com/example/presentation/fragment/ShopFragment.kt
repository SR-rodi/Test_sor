package com.example.presentation.fragment

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import androidx.core.content.res.ResourcesCompat
import com.example.core.BaseFragment
import com.example.core.dto.detailscreen.DetailInfoDto
import com.example.screen_detail.R
import com.example.screen_detail.databinding.FragmentShopBinding


class ShopFragment(private val detailInfoDto: DetailInfoDto) :
    BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {

    override fun initBinding(inflater: LayoutInflater) = FragmentShopBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isBindingInfo()

        isBackgroundRadioButton(detailInfoDto.color[0], binding.colorOne)

        isBackgroundRadioButton(detailInfoDto.color[1], binding.colorTwo)
    }

    private fun isBindingInfo() {
        binding.apply {
            cpu.text = detailInfoDto.CPU
            camera.text = detailInfoDto.camera
            data.text = detailInfoDto.ssd
            ram.text = detailInfoDto.sd
        }
    }

    private fun isBackgroundRadioButton(newColor: String, radioButton: RadioButton) {
        val ellipse: Drawable? =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_ellipse, null)
        ellipse!!.setTint(Color.parseColor(newColor))

        radioButton.background = ellipse
    }
}