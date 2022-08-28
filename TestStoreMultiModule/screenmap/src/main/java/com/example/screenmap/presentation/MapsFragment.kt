package com.example.screenmap.presentation

import android.annotation.SuppressLint
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.core.tools.checkPermissions
import com.example.screenmap.R
import com.example.screenmap.databinding.FragmentMapsBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.random.Random

class MapsFragment : Fragment() {

    private lateinit var map: GoogleMap

    var needAddMarker = true

    private lateinit var fusedClient: FusedLocationProviderClient
    private val launcher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { _map ->
            if (_map.values.isNotEmpty() && _map.values.all { it })
                determineMyPosition()
        }

    private val locationCallback by lazy {
        object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                result.lastLocation?.let { location ->
                    val myLocation = LatLng(location.latitude, location.longitude)
                    if (needAddMarker) {
                        needAddMarker = false
                        randomMarker(location)
                    }
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 10f))
                    Log.e("Mart", "Start")
                }
            }
        }
    }

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        val baseLocation = LatLng(55.7522, 37.6156)
        map.addMarker(MarkerOptions().position(baseLocation).title("Base Location"))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(baseLocation, 10f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        fusedClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        binding.buttonSearchLocation.setOnClickListener {
            fusedClient.removeLocationUpdates(locationCallback)
            mapFragment?.getMapAsync { googleMap ->
                checkPermissions(launcher) {
                    isMyLocationEnabled(googleMap)
                    determineMyPosition()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        fusedClient.removeLocationUpdates(locationCallback)
        needAddMarker = true
    }

    private fun randomMarker(location: Location) {
        for (i in 1..10) {
            val newMarkerLocation = LatLng(
                location.latitude + Random.nextDouble(-0.5000, 0.5000),
                location.longitude + Random.nextDouble(-0.5000, 0.5000)
            )
            map.addMarker(MarkerOptions().position(newMarkerLocation))
        }
    }

    @SuppressLint("MissingPermission")
    private fun isMyLocationEnabled(googleMap: GoogleMap) {
        googleMap.isMyLocationEnabled = true
    }

    @SuppressLint("MissingPermission")
    private fun determineMyPosition() {
        val request = LocationRequest
            .create()
            .setInterval(600_000)
            .setPriority(Priority.PRIORITY_LOW_POWER)

        fusedClient.requestLocationUpdates(
            request,
            locationCallback,
            Looper.getMainLooper()
        )
    }
}