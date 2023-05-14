package com.example.mymotorcycle.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymotorcycle.DetailMovieActivity
import com.example.mymotorcycle.Movie
import com.example.mymotorcycle.MovieAdapter
import com.example.mymotorcycle.R

class ExploreFragment : Fragment() {


    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.benelitnt600,
            R.drawable.energicaegoe45limitededition,
            R.drawable.h2,
            R.drawable.r6,
            R.drawable.mvagustarush1000,
            R.drawable.r1m,
            R.drawable.zx25r,
            R.drawable.zx6r636,
            R.drawable.panigalev4r,
            R.drawable.hondarc213vs,

            )

        title = arrayOf(
            "BENELI TNT 600",
            "ENERGI CAEGOE 45 LIMITED EDITION",
            "KAWASAKI H2",
            "YAMAHA R6",
            "MV AGUSTA RUSH 1000",
            "YAMAHA R1M",
            "KAWASAKI ZX25R",
            "KAWASAKI ZX6R 636",
            "DUCATI PANIGALE V4R",
            "HONDA RC213V-S",


            )

        descriptions = arrayOf(
            "Keluaran daya maksimum dari Benelli TNT 600i adalah 84 hp dan torsi maksimum adalah 54.6 Nm, TNT 250 ditenagai oleh Pendingin Cairan EFI 249 cc 2 Cylinder engine yang menghasilkan Tenaga 31.5 hp pada 10000 rpm and Torsi 20 Nm pada 9000 rpm",
            "POWER = 126 kw TORQUE= 222 Nm MAX SPEED = 240 km/h ACCELERATION0= 100 km/h 2.6 sec. RANGE = 420 km",
            "Kawasaki H2R, output yang bisa dihasilkannya memang lebih tinggi, yakni 326 Hp dan 165 Nm. Sementara pada Kawasaki H2 tenaganya dibatasi hanya sekuat 240 Hp dan 141,7 Nm.",
            "Motor ini memiliki mesin berkapasitas 599 cc DOHC, 4 silinder inline, berpendingin cairan, Yamaha R6 tersedia dalam pilihan mesin Petrol di Indonesia Sport baru dari Yamaha hadir dalam 2 varian. Bicara soal spesifikasi mesin Yamaha R6, ini ditenagai dua pilihan mesin Petrol berkapasitas 599 cc. R6 tersedia dengan transmisi Manual tergantung variannya.",
            "Rush mampu menghasilkan tenaga sebesar 208 hp pada 13.000 rpm, dengan torsi 116 Nm di putaran 11.000 rpm. Beda sedikit dari musuhnya yang menyemburkan power maksimum 208 hp pada 12.750 rpm, dan torsi 123 Nm pada putaran 11.500 rpm. Namun jika Rush digabungkan dengan Racing Kit, dayanya meningkat menjadi 212 hp. Silinder mesinnya diklaim berteknologi seperti Formula 1.",
            "R1M dibekali mesin 998 cc 4 langkah 4 silinder segaris DOHC 16 katup injeksi berpendingin cairan, Di atas kertas, motor ini dapat mengembuskan tenaga puncak sebesar 118.4 PS pada 14.500 Rpm, dan torsi puncak 61.7 Nm pada 10.500 Rpm.",
            "Ninja ZX-25R ditenagai oleh Pendingin Cairan 249.8 cc 4 Cylinder Mesin yang menghasilkan Tenaga 51 hp pada 15500 rpm dan Torsi 22.9 Nm pada 14500 rpm.",
            "Mesin Kawasaki Ninja ZX-6R ABS memiliki kapasitas 636 cc Inline 4 Cylinder 16 Valve, 4-Stroke, Liquid Cooled DOHC Engine .",
            "Basis mesin Ducati Panigale V4R diambil dari mesin Desmosedici Stradale R. Menggunakan konfigurasi 4 silinder V dengan sudut 90 derajat. Dibandingkan dengan 2 varian Panigale lainnya yang masuk ke Indonesia, sebenarnya kapasitasnya paling kecil yaitu 998 cc, DUCATI V4S TOP SPEED 374 KM/H - top speed ducati panigale v4r.",
            "Motor ini menggunakan mesin berpendingin cairan, 4-tak, DOHC 4 Valve, V-4 1000 cc yang menghasilkan tenaga sebesar 159 PS pada 11.000 rpm dan torsi 102 Nm pada 10.500 rpm, Honda RC213V geberan Marquez pun mampu menembus kecepatan maksimum 349,5 km/jam yang dibuatnya saat turun dengan paket aerodinamika lama.",
            )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}
