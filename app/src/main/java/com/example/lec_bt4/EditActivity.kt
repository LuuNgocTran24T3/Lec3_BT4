package com.example.lec_bt4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {

    private lateinit var edtHoTen: EditText
    private lateinit var btnLuu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        edtHoTen = findViewById(R.id.edtHoTen)
        btnLuu = findViewById(R.id.btnLuu)

        // Nhận họ tên từ MainActivity
        val hoTenHienTai =
            intent.getStringExtra("HO_TEN_HIEN_TAI")

        // Hiển thị họ tên hiện tại vào EditText
        if (hoTenHienTai != null) {
            edtHoTen.setText(hoTenHienTai)
        }

        // Xử lý khi bấm nút Lưu & Quay lại
        btnLuu.setOnClickListener {

            // Lấy họ tên mới
            val hoTenMoi = edtHoTen.text.toString()

            // Tạo Intent để trả dữ liệu về MainActivity
            val resultIntent = Intent()

            resultIntent.putExtra("HO_TEN_MOI", hoTenMoi)

            // Trả kết quả
            setResult(RESULT_OK, resultIntent)

            // Đóng EditActivity
            finish()
        }
    }
}