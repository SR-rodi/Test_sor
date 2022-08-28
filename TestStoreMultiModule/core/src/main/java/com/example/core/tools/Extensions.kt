package com.example.core.tools

import android.content.pm.PackageManager
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databasemodel.basket.BasketEntity
import com.example.core.databasemodel.detail.DetailEntity
import com.example.core.databasemodel.main.bestseller.BestSellerEntity
import com.example.core.databasemodel.main.hotsales.HotSalesEntity
import com.example.core.dtomodel.basketscreen.BasketPhoneDto
import com.example.core.dtomodel.detailscreen.DetailInfoDto
import com.example.core.dtomodel.mainscreen.nesteddto.BestSellerDto
import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto

fun ImageView.loadingGlide(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.drawable.ic_baseline_downloading_24)
        .error(R.drawable.ic_error)
        .into(this)
}


fun Fragment.checkPermissions(
    launcher: ActivityResultLauncher<Array<String>>,
    block: () -> Unit
) {
    if (REQUIRED_PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }) block()
    else launcher.launch(REQUIRED_PERMISSIONS)
}

fun BasketPhoneDto.toEntity() = BasketEntity(id, delivery, total, listBasket)

fun DetailInfoDto.toEntity() = DetailEntity(
    id, CPU, camera, capacity, color, images, isFavorites, price, rating, sd, ssd, title
)

fun DetailEntity.toDto() = DetailInfoDto(
    CPU, camera, capacity, color, id, images, isFavorites, price, rating, sd, ssd, title
)

fun List<BestSellerDto>.toBestSellerEntity(): MutableList<BestSellerEntity> {
    val bestSellerEntityList = mutableListOf<BestSellerEntity>()
    forEach { dto ->
        bestSellerEntityList.add(
            BestSellerEntity(
                dto.id,
                dto.is_favorites,
                dto.title,
                dto.price_without_discount,
                dto.discount_price,
                dto.picture
            )
        )
    }
    return bestSellerEntityList
}

fun List<HotSaleDto>.toHotSalesEntity(): MutableList<HotSalesEntity> {
    val hotSalesEntity = mutableListOf<HotSalesEntity>()
    forEach { dto ->
        hotSalesEntity.add(
            HotSalesEntity(
                dto.id, dto.is_new, dto.title, dto.subtitle, dto.picture, dto.is_buy
            )
        )
    }
    return hotSalesEntity
}

fun List<BestSellerEntity>.toBestSellerDto(): MutableList<BestSellerDto> {
    val bestSellerDtoList = mutableListOf<BestSellerDto>()
    forEach { entity ->
        bestSellerDtoList.add(
            BestSellerDto(
                entity.id,
                entity.is_favorites,
                entity.title,
                entity.price_without_discount,
                entity.discount_price,
                entity.picture
            )
        )
    }
    return bestSellerDtoList
}

fun List<HotSalesEntity>.toHotSalesDto(): MutableList<HotSaleDto> {
    val hotSalesDtoList = mutableListOf<HotSaleDto>()
    forEach { entity ->
        hotSalesDtoList.add(
            HotSaleDto(
                entity.id,
                entity.is_new,
                entity.title,
                entity.subtitle,
                entity.picture,
                entity.is_buy
            )
        )
    }
    return hotSalesDtoList
}