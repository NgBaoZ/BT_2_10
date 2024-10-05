package com.example.bt2_10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextFullName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var radioOther: RadioButton
    private lateinit var checkBoxTerms: CheckBox
    private lateinit var buttonSave: Button
    private lateinit var recyclerView: RecyclerView

    private val userList = mutableListOf<User>()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo các view bằng findViewById()
        editTextFullName = findViewById(R.id.editTextFullName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioMale = findViewById(R.id.radioMale)
        radioFemale = findViewById(R.id.radioFemale)
        radioOther = findViewById(R.id.radioOther)
        checkBoxTerms = findViewById(R.id.checkBoxTerms)
        buttonSave = findViewById(R.id.buttonSave)
        recyclerView = findViewById(R.id.recyclerView)

        // Thiết lập RecyclerView
        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        buttonSave.setOnClickListener {
            val fullName = editTextFullName.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            val gender = when {
                radioMale.isChecked -> "Nam"
                radioFemale.isChecked -> "Nữ"
                else -> "Khác"
            }

            // Thêm thông tin người dùng vào danh sách và cập nhật RecyclerView
            val user = User(fullName, email, phone, gender)
            userList.add(user)
            userAdapter.notifyItemInserted(userList.size - 1)

            // Xóa dữ liệu nhập để người dùng có thể nhập thông tin mới
            editTextFullName.text.clear()
            editTextEmail.text.clear()
            editTextPhone.text.clear()
            radioGroupGender.clearCheck()
            checkBoxTerms.isChecked = false
        }
    }
}
