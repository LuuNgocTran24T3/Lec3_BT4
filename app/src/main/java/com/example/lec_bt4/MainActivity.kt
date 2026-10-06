package com.example.lec_bt4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvHoTen: TextView
    private lateinit var btnChinhSua: Button

    // Nhận dữ liệu trả về từ EditActivity
    private val editLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val hoTenMoi =
                    result.data?.getStringExtra("HO_TEN_MOI")

                if (hoTenMoi != null) {
                    tvHoTen.text = hoTenMoi
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        tvHoTen = findViewById(R.id.tvHoTen)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        // Thông tin mặc định
        tvHoTen.text = "Chưa có thông tin"

        // Khi bấm nút Chỉnh sửa thông tin
        btnChinhSua.setOnClickListener {

            // Lấy họ tên hiện tại
            val hoTenHienTai =
                tvHoTen.text.toString()

            // Tạo Intent
            val intent =
                Intent(this, EditActivity::class.java)

            // Gửi họ tên sang EditActivity
            intent.putExtra(
                "HO_TEN_HIEN_TAI",
                hoTenHienTai
            )

            // Mở EditActivity
            editLauncher.launch(intent)
        }
    }
}